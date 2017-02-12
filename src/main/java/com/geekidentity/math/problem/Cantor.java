package com.geekidentity.math.problem;

import java.util.Scanner;

public class Cantor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		while (input.hasNext()) {
			n = input.nextInt();
			int k = 1, s = 0;
			for (;;) {
				s += k;
				if (s >= n) {
					break;
				}
				k++;
			}
			System.out.println(k);
		}
		
		input.close();
	}
}
