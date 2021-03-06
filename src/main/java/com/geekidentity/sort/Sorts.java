package com.geekidentity.sort;

/**
 * 排序
 * @author geekidentity
 * @date 2017年2月12日
 * @version 1.0
 *
 */
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
	
	public static void swap(Integer[] array, int a, int b) {
		Integer t = array[a];
		array[a] = array[b];
		array[b] = t;
	}
}
