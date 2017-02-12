package com.geekidentity.util;

/**
 * 基本数据类型的包装器类型
 * @author: 侯法超
 * @date: 2016年11月22日
 *
 */
public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean> {
		private boolean value = false;
		@Override
		public java.lang.Boolean next() {
			value = !value;
			return value;
		}
	}
	public static class Byte implements Generator<java.lang.Byte> {
		private byte value = 0;
		@Override
		public java.lang.Byte next() {
			return value++;
		}
	}
	public static char[] chars = ("abcdefghijklmnopqistuvwxyz").toCharArray();
}
