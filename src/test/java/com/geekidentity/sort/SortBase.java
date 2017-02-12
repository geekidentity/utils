package com.geekidentity.sort;

import java.util.Random;

public class SortBase {
	protected Integer[] array;
	protected Random rand = new Random();
	
	public void init(int n) {
		array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
	}
}
