package com.geekidentity.sort;

/**
 * 选择排序，所以大多数程序员入行第一个排序排序算法就是这个，<br>
 * 可以认为该算法是冒泡排序的优化：冒泡排序是通过相邻的比较进行交换。而选择排序是通过对整体的选择，从而减少了交换次数
 * @author geekidentity
 * @date 2017年2月12日
 * @version 1.0
 *
 */
public class SelectionSort {
	/**
	 * 选择排序，从小到大
	 * @param list
	 */
	public static void sort(Integer[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j] < list[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = list[i];
				list[i] = list[min];
				list[min] = temp;
			}
		}
	}
}
