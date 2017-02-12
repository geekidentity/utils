package com.geekidentity.search;

import java.util.Random;

public class ArrayUtil {
	
	/**
	 * 生成随机数组
	 * @param length
	 * @param bound
	 * @return
	 */
	public static int[]	randArray(int length, int bound) {
		int []array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = new Random().nextInt(bound);
		}
		return array;
	}
	
	public static void printArray(int []array) {
		for (int i = 0; i < array.length-1; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println(array[array.length-1]);
	}
}
