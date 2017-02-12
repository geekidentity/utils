package com.geekidentity.sort;

import com.geekidentity.datastructures.tree.MaxHeap;


public class HeapSort {
	
	/**
	 * 基于最大堆的堆排序，一次建堆，n次删除堆顶
	 * 时间复杂度为：nlog(n)
	 * @param array
	 */
	public static void sort(Integer[] array) {
		//建堆
		MaxHeap<Integer> heap = new MaxHeap<Integer>(array);
		//算法操作n-1次，最小元素不需要出堆
		for (int i = 0; i < array.length - 1; i++) {
			//依次找出剩余记录中的最大记录，即堆顶
			heap.removeMax();
		}
	}
}
