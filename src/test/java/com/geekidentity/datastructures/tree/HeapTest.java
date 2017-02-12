package com.geekidentity.datastructures.tree;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {
	
	private MinHeap<Integer> minHeap;
	private MaxHeap<Integer> maxHeap;
	private Random rand = new Random();
	private int size = 10;
	
	@Before
	public void init() {
		Integer[] array = new Integer[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
		minHeap = new MinHeap<Integer>(array);
	}
	
	@Test
	public void test() {
		for (int i = 0; i < size; i++) {
			System.out.println(minHeap.removeMin());
		}
	}

}
