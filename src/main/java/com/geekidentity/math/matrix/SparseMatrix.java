package com.geekidentity.math.matrix;

public class SparseMatrix implements Matrix {
	
	private Term [] terms;
	public SparseMatrix() {
	}
	
	public SparseMatrix(Term[] terms) {
		this.terms = terms;
	}

	public Matrix transpose() {
		int n = (int) terms[0].getValue();
		
		
		if (n > 0) {//非零矩阵
			for (int i = 0; i < terms[0].getCol(); i++) {
				for (int j = 0; j < n; j++) {
					
				}
			}
		}
		int t = terms[0].getCol();
		terms[0].setCol(terms[0].getRow());
		terms[0].setRow(t);
		return null;
	}


	public Term[] getTerms() {
		return terms;
	}

	public void setTerms(Term[] terms) {
		this.terms = terms;
	}

	@Override
	public int numRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSquare() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void set(int row, int column, double value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double add(int row, int column, double value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double get(int row, int column) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Matrix copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix zero() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
