package com.geekidentity.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 排序算法测试
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月24日  下午5:21:42
 * @version: V1.0
 *
 */
public class SortTest extends SortBase {
	
	@Before
	public void init() {
		init(10);
	}
	
	/**
	 * 冒泡排序测试
	 */
	@Test
	@Ignore
	public void bubbleSortTest() {
		BubbleSort.sort(array);
		System.out.println(Arrays.toString(array));
		assertEquals(true, Sorts.isAscendingSequence(array));
	}
	
	@Test
	@Ignore
	public void maxHeapTest() {
		System.out.println(Arrays.toString(array));
		HeapSort.sort(array);
		System.out.println(Arrays.toString(array));
		assertEquals(true, Sorts.isAscendingSequence(array));
	}
	
	@Test
	@Ignore
	public void quickSortTest() {
		QuickSort.sort(array, 0, array.length - 1);
		assertEquals(true, Sorts.isAscendingSequence(array));
		System.out.println(Arrays.toString(array));
	}
	
	@Test
	public void bucketSortTest() {
		int max = Sorts.max(array);
		System.out.println(Arrays.toString(array));
		BucketSort.sort(array, max);
		System.out.println(Arrays.toString(array));
		assertEquals(true, Sorts.isAscendingSequence(array));
		
	}
	
}
