package com.geekidentity.math.problem;

public class SnakArray {
	
	public static void main(String[] args) {
		snak(6, 6);
	}
	public static void snak(int n, int m) {
		int [][]a = new int[n][m];
		int tot = 1, x = 0, y = m-1;
		a[x][y] = 1; 
		while (tot < n*m) {
			while (x+1 < n && a[x+1][y]==0) {
				a[++x][y] = ++tot;
			}
			while (y-1>=0 && a[x][y-1]==0) {
				a[x][--y] = ++tot;
			}
			while (x-1 >=0 && a[x-1][y]==0) {
				a[--x][y] = ++tot;
			}
			while (y+1 < m && a[x][y+1]==0) {
				a[x][++y] = ++tot;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
