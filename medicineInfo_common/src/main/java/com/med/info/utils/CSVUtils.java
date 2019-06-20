package com.med.info.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csvreader.CsvWriter;

public class CSVUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CSVUtils.class);
	
	public static <T> void writeCSV(Collection<T> dataSet, String csvFilePath
			//, String[] csvHeaders
			) {
		try {
			// 判断文件是否存在,存在则删除,然后创建新表格
			File tmp = new File(csvFilePath);
			if (tmp.exists()) {
				if (tmp.delete()) {
					// logger.info(csvFilePath + Constant.DUPLICATE_FILE_DELETE);
				}
			}
			// 定义路径，分隔符，编码
			CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF8"));

			// 写表头
			//csvWriter.writeRecord(csvHeaders);

			// 遍历集合 写内容
			Iterator<T> it = dataSet.iterator();
			while (it.hasNext()) {
				T t = (T) it.next();
				// 获取类属性
				Field[] fields = t.getClass().getDeclaredFields();
				String[] csvContent = new String[fields.length];
				for (short i = 0; i < fields.length; i++) {
					Field field = fields[i];

					String fieldName = field.getName();
					String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					try {
						Class tCls = t.getClass();
						Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
						Object value = getMethod.invoke(t, new Object[] {});
						if (value == null) {
							continue;
						}
						// 取值并赋给数组
						String textValue = value.toString();
						// 报错：因为get方法是private，所以不能访问
						// String textValue = field.get(t).toString();
						csvContent[i] = textValue;
					} catch (Exception e) {
						e.getStackTrace();
					}
				}
				// 迭代插入记录
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("<--------CSV文件写入成功-------->");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("请先关闭已经打开的文件！");
		}
	}
	
	/** CSV文件列分隔符 */
    private static final String CSV_COLUMN_SEPARATOR = ",";

    /** CSV文件列分隔符 */
    private static final String CSV_RN = "\r\n";

    /**
     *
     * @param dataList 集合数据
     * @param colNames 表头部数据
     * @param mapKey 查找的对应数据
     * @param os 返回结果
     */
    public static boolean doExport(List<Map<String, Object>> dataList, String colNames, String mapKey, OutputStream os) {
        try {
            StringBuffer buf = new StringBuffer();

            String[] colNamesArr = null;
            String[] mapKeyArr = null;

            colNamesArr = colNames.split(",");
            mapKeyArr = mapKey.split(",");

            // 完成数据csv文件的封装
            // 输出列头
            for (String aColNamesArr : colNamesArr) {
                buf.append(aColNamesArr).append(CSV_COLUMN_SEPARATOR);
            }
            buf.append(CSV_RN);

            if (null != dataList) { // 输出数据
                for (Map<String, Object> aDataList : dataList) {
                    for (String aMapKeyArr : mapKeyArr) {
                        buf.append(aDataList.get(aMapKeyArr)).append(CSV_COLUMN_SEPARATOR);
                    }
                    buf.append(CSV_RN);
                }
            }
            // 写出响应
            os.write(buf.toString().getBytes("GBK"));
            os.flush();
            return true;
        } catch (Exception e) {
        	logger.error("doExport错误...", e);
        }
        return false;
    }
}
