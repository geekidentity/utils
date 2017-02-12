package com.geekidentity.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序 ：它的优势在于在对一定范围内的整数排序时，它的复杂度为Ο(n+k)（其中k是整数的范围），
 * 快于任何比较排序算法。
 * @author 侯法超
 * @date  2016年9月12日  上午1:01:30
 *
 */
public class CountingSort {
	public static void main(String[] args) {
		int n = 100;
		int []arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(1000);
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("max="+max);
		int []counting = new int[max+1];
		for (int i = 0; i < arr.length; i++) {
			counting[arr[i]]++;
		}
		for (int i = 0; i < counting.length; i++) {
			for (int j = 0; j < counting[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}
}
