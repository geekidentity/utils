package com.geekidentity.test;

import com.geekidentity.math.Maths;

public class Test {
	public static void main(String[] args) {
		genKunth(2, 5);
	}
	
	public static void genKunth(int m, int n) {
		for (int i = 0; i < m; i++) {
			//从剩余n-i个中选出m个
			if (Maths.random(m, n)%(n-i) < m) {
				System.out.println(i);
				m--;
			}
		}
	}
}
