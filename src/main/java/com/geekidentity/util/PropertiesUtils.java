package com.geekidentity.util;

import java.util.ResourceBundle;

public class PropertiesUtils {
	private static ResourceBundle rs = ResourceBundle.getBundle("app");
	
	public static String getValue(String key) {
		return rs.getString(key);
	}
}
