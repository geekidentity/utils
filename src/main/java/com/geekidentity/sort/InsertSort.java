package com.geekidentity.sort;

/**
 * 插入排序
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月19日  下午3:30:06
 * @version: V1.0
 *
 */
public class InsertSort {
	/**
	 * 用插入排序算法对数组进行升序排序
	 * @param array
	 */
	public static void sort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			temp = array[i];
			int j = i - 1;
			while (j >= 0 && temp < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
}
