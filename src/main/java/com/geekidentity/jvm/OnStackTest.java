package com.geekidentity.jvm;

public class OnStackTest {
	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			alloc();
		}
		long e = System.currentTimeMillis();
		System.out.println(e - b);
	}
	
	public static void alloc() {
		byte[] b = new byte[2];
		b[0] = 1;
	}
}
