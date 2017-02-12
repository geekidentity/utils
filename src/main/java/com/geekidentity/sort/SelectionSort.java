package com.geekidentity.sort;

import com.geekidentity.search.ArrayUtil;

public class SelectionSort {
	/**
	 * 选择排序，从小到大
	 * @param list
	 */
	public static void sort(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int max = i;
			for (int j = i+1; j < list.length; j++) {
				if (list[j] < list[i]) {
					max = j;
				}
			}
			int temp = list[i];
			list[i] = list[max];
			list[max] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = ArrayUtil.randArray(10, 100);
		ArrayUtil.printArray(a);
		sort(a);
		ArrayUtil.printArray(a);
	}
}
