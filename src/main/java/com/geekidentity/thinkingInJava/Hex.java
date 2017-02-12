package com.geekidentity.thinkingInJava;

/**
 * 十六进制转储工具（dump）
 * 
 * 在处理二进制文件时，可以以十六进制的格式查看其内容。
 * 
 * @Title: Hex.java
 * @Project: Utils
 * @Package: com.geekidentity.test
 * @author: 侯法超
 * @date: 2016年10月1日  下午7:24:29
 * @version: V1.0
 *
 */
public class Hex {
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if (n%16 == 0) {
				result.append(String.format("%05X: ", n));
			}
			result.append(String.format("%02X ", b));
			n++;
			if (n%16 == 0) {
				result.append("\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
}
