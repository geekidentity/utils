package com.geekidentity.string;

/**
 * 利用正则表达式的一些常用帮助方法
 * @Project: Utils
 * @Package: com.geekidentity.string
 * @Description: TODO
 * @author: 侯法超
 * @date: 2016年10月1日  下午8:14:03
 * @version: V1.0
 *
 */
public class RegExpUtil {
	
	/**
	 * 判断一个数是否是正整数
	 * @param value
	 * @return
	 */
	public static boolean isPositiveInteger(int value) {
		return Integer.valueOf(value).toString().matches("\\d+");
	}
	
	/**
	 * 判断一个数是否是负数
	 * @param value
	 * @return
	 */
	public static boolean isNegativeInteger(int value) {
		return Integer.valueOf(value).toString().matches("-\\d+");
	}
	
	/**
	 * 判断一个数是否是整数
	 * @param value
	 * @return
	 */
	public static boolean isInteger(int value) {
		return Integer.valueOf(value).toString().matches("(-|\\+)?\\d+");
	}
	
	
	
}
