package com.geekidentity.jvm;

import java.util.List;
import java.util.Vector;

public class LockTest {
	
	public static void main(String[] args) {
		biasedTest();
	}
	
	private static List<Integer> list = new Vector<Integer>();
	public static void biasedTest() {
		long begin = System.currentTimeMillis();
		int count = 0;
		while (count < 10000000) {
			list.add(count);
			count++;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
}
