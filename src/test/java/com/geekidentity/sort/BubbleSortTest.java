package com.geekidentity.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 冒泡排序测试
 * @author geekidentity
 *
 */
public class BubbleSortTest extends SortTestBase {

	@Test
	public void bubbleSortTest() {
		BubbleSort.sort(array);
		System.out.println(Arrays.toString(array));
		assertEquals(true, Sorts.isAscendingSequence(array));
	}
	
}
