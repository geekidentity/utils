package com.geekidentity.math.problem;

/**
 * 汉诺塔问题分析
 * 这个移动过程很复杂与烦琐，但规律性却很强。
 * 使用递归调用技术来解决这个移动过程，先得找一个递归调用模型。
 * 解法的着眼点应该是移动A杆最底部的大盘，而不是其顶部的小盘。
 * 要想将A杆上的N个盘移至C杆，我们可以这样设想：
 * 1：以C盘为临时杆，从A杆将1至n-1号盘移至B杆；
 * 2：将A杆中剩下的第n号盘移至C杆；
 * 3：以A杆为临时杆，从B杆将1至n-1号盘移至C杆。
 * @Project: Utils
 * @Package: com.geekidentity.math.problem
 * @author: 侯法超
 * @date: 2016年10月27日  下午6:36:01
 * @version: V1.0
 *
 */
public class Hanoi {
	public static void hanoi(int n, char X, char Y, char Z) {
		if (n <= 2) {
			move(X, Z);
		} else {
			hanoi(n-1, X, Z, Y);
			move(X, Z);
			hanoi(n-1, Y, X, Z);
		}
	}
	
	public static void move(char X, char Y) {
		System.out.println("move " + X + " to " + Y);
	}
	
	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
}
