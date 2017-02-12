package com.geekidentity.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSortTest extends SortTestBase {
	
	@Test
	public void selectionSortTest() {
		System.out.println("排序前: " + Arrays.toString(array));
		SelectionSort.sort(array);
		System.out.println("排序后: " + Arrays.toString(array));
		assertEquals(true, Sorts.isAscendingSequence(array));
	}
}
