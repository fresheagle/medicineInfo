package com.med.info.utils;

import java.util.UUID;

public class UuidUtils {
	
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}

}
