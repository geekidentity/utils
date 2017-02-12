package com.geekidentity.sort;

/**
 * Shell排序
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月19日  下午8:54:14
 * @version: V1.0
 *
 */
public class ShellSort {
	
	/**
	 * 增量除2递减的Shell排序
	 * @param array 待排数组
	 */
	public static void sort(int[] array) {
		int n = array.length;
		//增量delta每次除以3递减
		for (int delta = n/3; delta > 0; delta /= 2) {
			for (int i = 0; i < delta; i++) {
				//分别对delta个子序列进入插入排序
				modInsertSort(array, n - i, delta);
			}
		}
		/*
		 * 如果增量序列不能保证最后一个delta间距为1
		 * 可以安排下面这个扫尾性质的插入排序
		 */
		//modInsertSort(array, n, 1);
	}
	
	/**
	 * 针对增量而修改的插入排序算法
	 * @param array 待排数组
	 * @param n 去除已经处理过的子序列的元素个数
	 * @param delta 逻辑步长，在delta步长里是一组待排数组
	 */
	public static void modInsertSort(int[] array, int n, int delta) {
		//对子序列中第i个记录，寻找合适的插入位置
		for (int i = delta; i < n; i++) {
			//j以delta为步长向前寻找逆序对进行调整
			for (int j = i; j >= delta; j -= delta) {
				if (array[j] < array[j - delta]) {//如果是逆序对
					int temp = array[j];
					array[j] = array[j - delta];
					array[j - delta] = temp;
				} else {
					break;
				}
			}
		}
	}
}
