/**
 * 
 */
package com.med.info.service;

import com.med.info.dto.ImageResponseDTO;

import java.io.File;
import java.util.List;

/**
 * @author jialin.jiang
 *
 */
public interface AliyunOSSService {
	
	/**
	 * @author jialin.jiang
	 * Function: 上传文件并生产对应文件key <br/> 
	 * @param file
	 * @return
	 */
	public ImageResponseDTO upload(File file);
	
	/**
	 * 
	 * @author jialin.jiang
	 * Function: 通过文件key查找并生成可访问url <br/> 
	 * @param fileName
	 * @return
	 */
	public String searchOSS(String fileName);
	
	/**
	 * 
	 * @author jialin.jiang
	 * Function: 通过文件key下载对应文件destFile <br/> 
	 * @param fileName
	 * @return
	 */
	public void download(String fileName, File destFile);

}
