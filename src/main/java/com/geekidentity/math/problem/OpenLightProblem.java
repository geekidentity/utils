package com.geekidentity.math.problem;

import java.util.Scanner;

public class OpenLightProblem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n,m;
		n = input.nextInt();
		m = input.nextInt();
		int [] lights = new int[n];
		for (int i = 2; i <= m; i++) {
			for (int j = 0; j < lights.length; j++) {
				if ((j+1)%i==0) {
					lights[j] = lights[j] == 1?0:1;
				}
			}
		}
		for (int i = 0; i < lights.length; i++) {
			if (lights[i]==0) {
				System.out.print((i+1)+"\t");
			}
		}
		
		input.close();
	}
}
