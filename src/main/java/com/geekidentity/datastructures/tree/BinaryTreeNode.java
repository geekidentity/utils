package com.geekidentity.datastructures.tree;

/**
 * 二叉树结点
 * @author 侯法超
 * @date  2016年9月27日  下午4:16:58
 *
 * @param <E>
 */
public class BinaryTreeNode<E extends Comparable<E>> implements Node<E> {
	
	//数据元素
	private E element;
	
	//左子树
	private Node<E> left;
	
	//右子树
	private Node<E> right;
	
	/**
	 * 结定数据的构造
	 * @param element
	 */
	public BinaryTreeNode(E element) {
		this.element = element;
	}
	
	/**
	 * 子树构造函数
	 * @param element
	 * @param leftchild
	 * @param rightchild
	 */
	public BinaryTreeNode(E element, Node<E> leftchild, Node<E> rightchild) {
		this.element = element;
		this.left = leftchild;
		this.right = rightchild;
	}
	
	@Override
	public E getElement() {
		return element;
	}

	@Override
	public Node<E> getLeftchild() {
		return left;
	}

	@Override
	public Node<E> getRightchild() {
		return right;
	}

	@Override
	public void setLeftchild(Node<E> leftchildNode) {
		this.left = leftchildNode;
	}

	@Override
	public void setRightchild(Node<E> rightchildNode) {
		this.right = rightchildNode;
	}

	@Override
	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public boolean isLeaf() {
		return (left == null)&&(right == null);
	}

	@Override
	public int compareTo(E o) {
		return 0;
	}

	@Override
	public Node<E> getParent() {
		// TODO Auto-generated method stub
		return null;
	}



}
