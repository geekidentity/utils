package com.geekidentity.sort;

/**
 * 归并排序
 * 1：划分为两个子序列
 * 2：分别对每个子序列归并排序
 * 3：有序子序列合并
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月28日  上午11:44:47
 * @version: V1.0
 *
 */
public class MergeSort {
	
	/**
	 * 
	 * @param array 待排数组
	 * @param tempArray 临时数组
	 * @param left 
	 * @param right
	 */
	public static void mergeSort(Integer[] array, Integer[] tempArray, int left, int right) {
		int middle;
		if (left < right) {//序列中只有0或1个纪录，不用排序
			middle = (left + right)/2;//平分2个子序列
			//对左半边一半进行递归
			mergeSort(array, tempArray, left, middle);
			//对右半边一半进行递归
			mergeSort(array, tempArray, middle, right + 1);
			//归并
			merge(array, tempArray, left, right, middle);
		}
	}

	/**
	 * 最后进行的归并操作
	 * 两个有序子序列都从左向右扫描，归并到新数组
	 * @param array
	 * @param tempArray
	 * @param left
	 * @param right
	 * @param middle
	 */
	private static void merge(Integer[] array, Integer[] tempArray, int left, int right, int middle) {
		// TODO Auto-generated method stub
		System.arraycopy(array, 0, tempArray, 0, array.length);//将数组暂存入临时数组
		int index1 = left;//左边子序列的起始位置
		int index2 = middle;//右边子序列的起始位置
		int i = index1;//从左开始归并
		while (index1 <= middle && index2 <= right) {
			//取较小者插入合并数组中
			if (tempArray[index1] <= tempArray[index2]) {
				array[i++] = tempArray[index1++];
			} else {
				array[i++] = tempArray[index2++];	
			}
			while (index1 <= middle) {//只剩左序列，可以直接
				array[i++] = tempArray[index1++];
			}
			while (index2 <= right) {//与上个循环互斥，复制右序列
				array[i++] = tempArray[index2++];
			}
			
		}
	}
}
