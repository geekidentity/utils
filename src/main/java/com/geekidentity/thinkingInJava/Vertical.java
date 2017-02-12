package com.geekidentity.thinkingInJava;

import java.util.Arrays;
import java.util.Scanner;

public class Vertical {
	public static void main(String[] args) {
		
		int count = 0, x, y, z;
		String t;
		Scanner input = new Scanner(System.in);
		char []s = input.nextLine().toCharArray();
		for (int i = 111; i < 999; i++) {
			for (int j = 11; j < 99; j++) {
				x = i*(j%10);
				y = i*(j/10);
				z = i * j;
				t = x+""+y+""+z+""+i+""+j;
				
				
				boolean ok = true;
				for (char c : t.toCharArray()) {
					if (Arrays.binarySearch(s, c)==-1) {
						ok = false;
						break;
					}
				}
				if (ok) {
					System.out.println("<" + ++count + ">");
					System.out.println(t);
					System.out.format("%5d\n", i);
				}
			}
			
		}
		input.close();
	}
}
