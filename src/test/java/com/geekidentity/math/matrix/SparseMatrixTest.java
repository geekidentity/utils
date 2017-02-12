package com.geekidentity.math.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	public void before() {
		
		Term []terms = {new Term(6, 6, 8), new Term(0, 0, 15), new Term(0, 3, 22),
				new Term(0, 5, -15), new Term(1, 1, 11), new Term(1, 2, 3),
				new Term(2, 3, -6), new Term(4, 0, 91), new Term(5, 2, 28)};
		SparseMatrix matrix = new SparseMatrix(terms);
	}
	
	@Test
	public void test() {
	}

}
