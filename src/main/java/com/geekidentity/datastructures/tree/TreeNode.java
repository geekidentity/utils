package com.geekidentity.datastructures.tree;

public class TreeNode<E> implements Node<E> {
	
	private E element;
	//第一个左孩子
	private Node<E> leftchild;
	private Node<E> sibling;
	
	/**
	 * 以第一个左孩子身份插入结点
	 * @param node
	 */
	public void insertFisrt(Node<E> node) {
		
	}
	
	/**
	 * 以右兄弟的身份插入结点
	 * @param node
	 */
	public void insertNext(Node<E> node) {
		
	}

	/**
	 * 返回第一个左孩子
	 * @return
	 */
	public Node<E> getLeftMostChild() {
		return leftchild;
	}
	
	/**
	 * 返回右弟兄
	 * @return
	 */
	public Node<E> getRightSibling() {
		return sibling;
	}
	
	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E getElement() {
		return element;
	}

	@Override
	public Node<E> getLeftchild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> getRightchild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeftchild(Node<E> leftchildNode) {
		this.leftchild = leftchildNode;
	}

	@Override
	public void setRightchild(Node<E> rightchildNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node<E> getParent() {
		
		return null;
	}

}
