package com.geekidentity.sort;

/**
 * 冒泡排序
 * 交换排序的一种
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月20日  下午10:11:18
 * @version: V1.0
 */
public class BubbleSort {
	public static void sort(Integer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean isSwap = true;//是否发生了交换的标志
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
			if (!isSwap) {
				return ;
			}
		}
	}
}
