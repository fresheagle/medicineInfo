package com.med.info.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectMapUtil {

    private static Logger logger = LoggerFactory.getLogger(SelectMapUtil.class);

    public static Map converseObjectToMap(Object o) {
        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(o);
                if(field.getName().endsWith("Time") && null != fieldValue){
                    List<Date> dates = (List<Date>) fieldValue;
                    if(dates.size() == 0){
                        continue;
                    }
                    map.put(field.getName()+"Begin",dates.get(0));
                    map.put(field.getName()+"End",dates.get(1));
                }else if (null != fieldValue) {
                    if(fieldValue.toString().equals("")){
                        continue;
                    }
                    if(fieldValue instanceof List){
                        List listValue = (List) fieldValue;
                        if(listValue.size() == 0){
                            continue;
                        }
                        if(listValue.get(0) instanceof String){
                            List<String> listStrValue = (List<String>) fieldValue;
                            if(listStrValue.contains("all")){
                                continue;
                            }
                        }
                    }
                    if(fieldValue.toString().equals("all")){
                        continue;
                    }
                    map.put(field.getName(), fieldValue);
                }
            } catch (IllegalAccessException e) {
                logger.error("获取对应feild失败", e);
            }
        }
        return map;

    }
}
