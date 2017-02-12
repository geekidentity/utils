package com.geekidentity.math.problem;

/**
 * 迷宫问题（经典的搜索问题）
 * （注：1为墙 0为路 2为已经走过）
 * 扩充一圈，加监视哨
 * 遍历顺序：上右下左
 * 
 * 从入口出发，沿某一方向进行探索，若能走通，则继续前走；否则沿原路返回，换一方向再进行探索，直到遇到出口或
 * 所有可能的通路都探索到为止
 * @Project: Utils
 * @Package: com.geekidentity.math.problem
 * @author: 侯法超
 * @date: 2016年10月27日  下午6:53:47
 * @version: V1.0
 *
 */
public class Maze {
	
	/**
	 * 在迷宫maze[][]中，求从入口maze[x1][y1]到出口maze[x2][y2]的一条路径，
	 * @param maze 传入的迷宫
	 * @param direction [4][2] 四个方向<br>
	 * 0:0,1     方向E<br>
	 * 1:1,0     方向S<br>
	 * 2:0,-1  方向W<br>
	 * 3:-1,0  方向N<br>
	 * 
	 * @param x1 入口x坐标
	 * @param y1 入口y坐标
	 * @param x2 出口x坐标
	 * @param y2 出口y坐标
	 */
	public static int mazePath(int[][] maze, int direction[][], int x1, int y1, int x2, int y2) {
		//枚举4个不同的方向
		for (int i = 0; i < 4; i++) {
			int g = x1 + direction[i][0];
			int h = y1 + direction[i][1];
			if (maze[g][h] >= 1) {//遇到墙或已经搜索过
				continue;
			}
			if (g == x2 && h == y2 && maze[g][h] == 0) {
				System.out.println(x1 +", " + y1);
				return 1;
			}
			maze[g][h] = 2;//标记已经搜索过
			if (mazePath(maze, direction, g, h, x2, y2) == 1) {//表示搜索成功，输出
				System.out.println(x1 + ", " + y1);
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		//TODO 这个还没解决
		int maze[][] = new int[][]{
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
				{1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1},
				{1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1},
				{1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
				{1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1},
				{1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
		
		int[][] direction = {
				{0,1}, {1,0}, {0,-1},{-1,0}
		};
		mazePath(maze, direction, 1, 1, 9, 16);
	}
}
