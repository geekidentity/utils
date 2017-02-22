package com.geekidentity.sort;

/**
 * 直接插入排序，该算法是稳定的，
 * @author: 侯法超
 * @date: 2016年10月19日  下午3:30:06
 * @version: V1.0
 *
 */
public class InsertSort {
	/**
	 * 直接插入排序算法对数组进行升序排序<br>
	 * @param array 待排数组
	 */
	public static void sort1(Integer[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) { //依次插入第i 个记录
			temp = array[i];
			//从i 开始向前寻找记录i 的正确位置
			int j = i - 1;
			while (j >= 0 && temp < array[j]) {
				//将那些 >= 记录i 的记录后移
				array[j+1] = array[j];
				j--;
			}
			//最后j 后面就是i 的正确位置，回填
			array[j+1] = temp;
		}
	}
}
