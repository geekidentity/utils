package com.geekidentity.sort;

import java.util.Arrays;

public class BucketSort {
	
	public static void sort(Integer[] array, int max) {
		Integer[] tempArray = new Integer[array.length];//临时数组
		Integer[] count = new Integer[max + 1];//桶容量计数器
		System.arraycopy(array, 0, tempArray, 0, array.length);//把序列复制到临时数组
		for (int i = 0; i < count.length; i++) {//将桶中数值设为0
			count[i] = 0;
		}
		for (int i = 0; i < array.length; i++) {//统计每个取值出现的次数
			count[array[i]]++;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 1; i <= max; i++) {//统计小于等于i的元素的个数
			count[i] = count[i-1] + count[i];
		}
		System.out.println(Arrays.toString(count));
		for (int i = array.length - 1; i >= 0; i--) {//从尾部开始，保证稳定性
			array[--count[tempArray[i]]] = tempArray[i];
		}
	}
}
