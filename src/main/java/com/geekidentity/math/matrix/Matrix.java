package com.geekidentity.math.matrix;

/**
 * 矩阵的基本接口
 * @author 侯法超
 * @date  2016年9月23日  上午9:06:49
 *
 */
public interface Matrix {
	
	/**
	 * 矩阵的行数
	 */
	int numRows();
	
	/**
	 *矩阵的列数
	 */
	int numColumns();
	
	/**
	 * 该矩阵是否是方阵
	 */
	boolean isSquare();
	
	/**
	 * <code>A(row,column) = value</code>
	 * @param row
	 * @param column
	 * @param value
	 */
	void set(int row, int column, double value);
	
	/**
	 * <code>A(row,column) += value</code>
	 * @param row
	 * @param column
	 * @param value
	 * @return
	 */
	double add(int row ,int column, double value);
	
	/**
	 * 返回<code>A(row,column)</code>
	 * @param row
	 * @param column
	 * @return
	 */
	double get(int row, int column);
	
	/**
	 * 矩阵的深度复制
	 * @return A
	 */
	Matrix copy();
	
	/**
	 * 将矩阵所有元素置为0
	 * @return
	 */
	Matrix zero();
	
	//TODO: Vector
	
	/**
	 * 将矩阵就地进行转置。大多数情况下矩阵必须是方阵。
	 * @return 当前矩阵
	 */
	Matrix transpose();
	
	
}
