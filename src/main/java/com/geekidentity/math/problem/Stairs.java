package com.geekidentity.math.problem;

/**
 * 上楼梯问题
 * 有n步台阶，一次只能上1步或2步，共有多少种走法。
 * @Project: Utils
 * @Package: com.geekidentity.math.problem
 * @author: 侯法超
 * @date: 2016年10月15日  下午8:27:11
 * @version: V1.0
 *
 */
public class Stairs {
	public static void main(String[] args) {
		System.out.println(f(12));
	}
	
	public static int f(int n) {
		if (n <= 2) {
			return n;
		}
		int x = f(n-1) + f(n-2);
		return x;
	}
}
