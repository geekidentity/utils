package com.geekidentity.math.base;

import java.util.Scanner;

public class BigInt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int []bit = new int[300];
		int n = input.nextInt();
		bit[0] = 1;
		for (int i = 2; i <= n; i++) {//乘以i
			int c = 0;//进位用，前一个运算进的数
			for (int j = 0; j < bit.length; j++) {
				int t = bit[j]*i+c;
				bit[j] = t%10;//本位进位后加的数
				c = t/10;//进位
			}
			
		}
		int digit = 0;
		for (int i = bit.length-1; i > 0; i--) {
			if (bit[i]!=0) {
				digit = i+1;
				break;
			}
		}
		for (int i = digit-1; i >= 0; i--) {
			System.out.print(bit[i]);
		}
		input.close();
	}
	
	/**
	 * 加法进位
	 */
	public static void carry() {
		Scanner input = new Scanner(System.in);
		int a, b, c, count = 0;
		while (input.hasNext()) {
			a = input.nextInt();
			b = input.nextInt();
			c = 0;
			count = 0;
			for (int i = 0; i <= 9; i++) {
				c = (a%10 + b%10 + c) > 9?1:0;
				count += c;
				a /= 10;
				b /= 10;
			}
			System.out.println(count);
		}
		input.close();
	}
}
