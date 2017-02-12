package com.geekidentity.search;

import com.geekidentity.sort.SelectionSort;

public class BinarySearch {
	/**
	 * 
	 * @param array 升序
	 * @param target
	 * @return
	 */
	public static int search(int []array,int target) {
		int n = array.length, left = 0, right = n-1, middle;
		while (left<=right) {
			middle = (left+right)/2;
			if (target > array[middle]) {
				left = middle+1;
			} else if (target < array[middle]) {
				right = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	public static int binsearch(int []array, int target, int left, int right) {
		int middle;
		if (left <= right) {
			middle = (left+right)/2;
			if (target < array[middle]) {
				return binsearch(array, target, left, right-1);
			} else if (target > array[middle]) {
				return binsearch(array, target, left+1, right);
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int []array = ArrayUtil.randArray(10, 100);
		SelectionSort.sort(array);
		ArrayUtil.printArray(array);
		for (int i = 0; i < array.length; i++) {
			int index = BinarySearch.binsearch(array, array[i], 0, array.length);
			System.out.println(index);
		}
		
	}
}
