package com.geekidentity.datastructures.tree;

public interface Node<E> extends Comparable<E> {
	/**
	 * 返回当前结点数据
	 * @return
	 */
	E getElement();
	
	/**
	 * 返回当前结点的父结点
	 * @return
	 */
	Node<E> getParent();
	
	/**
	 * 返回左子树
	 * @return
	 */
	Node<E> getLeftchild();
	
	/**
	 * 返回右子树
	 * @return
	 */
	Node<E> getRightchild();
	
	/**
	 * 设置左子树
	 * @param leftchildNode
	 */
	void setLeftchild(Node<E> leftchildNode);
	
	/**
	 * 设置右子树
	 * @param rightchildNode
	 */
	void setRightchild(Node<E> rightchildNode);

	/**
	 * 设置数据域
	 * @param element
	 */
	void setElement(E element);
	
	/**
	 * 是否是叶子结点
	 * @return
	 */
	boolean isLeaf();
}
