package com.geekidentity.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertSortTest extends SortTestBase {

	@Test
	public void sort1Test() {
		init(10000);
		InsertSort.sort1(array);
		assertEquals(true, Sorts.isAscendingSequence(array));
	}

}
