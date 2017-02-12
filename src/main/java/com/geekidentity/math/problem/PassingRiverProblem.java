package com.geekidentity.math.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 农夫过河问题
 * @Project: Utils
 * @Package: com.geekidentity.math.problem
 * @author: 侯法超
 * @date: 2016年11月1日  上午11:09:37
 * @version: V1.0
 *
 */
public class PassingRiverProblem {
	
	public static void main(String[] args) {
		solve();
	}
	
	/**
	 * 
	 */
	public static void solve() {
		int movers;
		int[] route = new int[16];//记录已考虑的状态路径-1表示该状态没有考虑过
		for (int j = 0; j < route.length; j++) {
			route[j] = -1;
		}
		Queue<Integer> moveTo = new LinkedList<Integer>();
		//初值准备
		moveTo.add(0x00);
		route[0] = 0;
		
		while (!moveTo.isEmpty() && route[15]==-1) {
			//得到现在的状态
			int status = moveTo.poll();
			for(movers = 1; movers <=8; movers <<= 1) {
				//农夫总是在移动，随农夫移动的也只能是在农夫同侧的东西
				if (farmer(status) == (status&movers) > 0 ? true : false) {
					int newStatus = status & (0x08|movers);
					//安全的，并且未考虑过的走法
					if (safe(newStatus) && route[newStatus] == -1) {
							route[newStatus] = status;
							moveTo.add(newStatus);
					}
				}
			}
		}
		
		//反向打印出路径
		if (route[15] != -1) {
			System.out.println("The reverse path is: ");
			for (int status = 15; status >= 0; status = route[status]) {
				System.out.println("The status is: " + status);
				if (status == 0) {
					break ;
				}
			}
		} else {
			System.out.println("No solution");
		}
	}
	
	/**
	 * 判断当前状态是否安全
	 * @param status
	 * @return
	 */
	public static boolean safe(int status) {
		if (goat(status) == wolf(status) && farmer(status) != goat(status)) {//羊吃白菜
			return false;
		}
		if (goat(status) == cabbage(status) && farmer(status) != goat(status)) {//狼吃羊
			return false;
		}
		
		return true;
	}
	
	/**
	 * 1是否在目标岸<br>
	 * 1000：表示农夫在目标岸
	 * @param status
	 * @return
	 */
	public static boolean farmer(int status) {
		return (status & 0x08) != 0;
	}
	
	/**
	 * 狼是否在目标岸
	 * 0100：表示狼在目标岸
	 * @param status
	 * @return
	 */
	public static boolean wolf(int status) {
		return (status & 0x04) != 0;
	}
	
	/**
	 * 菜是否在目标岸
	 * 0010：表示狼在目标岸
	 * @param status
	 * @return
	 */
	public static boolean cabbage(int status) {
		return (status & 0x02) != 0;
	}
	
	/**
	 * 羊是否在目标岸
	 * 0001：表示羊在目标岸
	 * @param status
	 * @return
	 */
	public static boolean goat(int status) {
		return (status & 0x01) != 0;
	}
	
}
