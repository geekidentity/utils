package com.geekidentity.math.matrix;

/**
 * sparse matrix term
 * @author 侯法超
 * @date  2016年9月1日  上午11:02:38
 *
 */
public class Term {
	private int row;
	private int col;
	private double value;
	public Term() {
	}
	
	public Term(int row, int col, double value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
