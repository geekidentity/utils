package com.geekidentity.sort;


public class Sorts {
	
	/**
	 * 判断一个数组是否是升序
	 * @param array
	 * @return
	 */
	public static boolean isAscendingSequence(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断一个数组是否是降序
	 * @param array
	 * @return
	 */
	public static boolean isDescendingOrder(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] < array[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 返回数组里的最大值
	 * @param array
	 * @return
	 */
	public static int max(Integer[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
}
