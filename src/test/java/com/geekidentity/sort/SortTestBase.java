package com.geekidentity.sort;

import java.util.Random;

/**
 * 排序测试基类
 * @author geekidentity
 * @date 2017年2月12日
 * @version 1.0
 *
 */
public class SortTestBase {
	protected Integer[] array;
	protected Random rand = new Random();
	
	/**
	 * 提供默认大小为10 的测试数组
	 */
	public SortTestBase() {
		array = new Integer[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
	}
	
	public void init(int n) {
		array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
	}
}
