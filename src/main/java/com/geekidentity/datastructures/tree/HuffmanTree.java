package com.geekidentity.datastructures.tree;

public class HuffmanTree<E extends Comparable<E>> implements Tree<E> {
	
	//Huffman树的树根
	
	/**
	 * 构造Huffman树
	 * @param weight 存储权值的树组
	 */
	public HuffmanTree(int[] weight) {
	}
	
	/**
	 * 把以left、right为根的2棵树合并成以parent为根的Huffman子树
	 * @param left
	 * @param right
	 * @param parent
	 */
/*	private void mergeTree(HuffmanTreeNode left, HuffmanTreeNode right, HuffmanTreeNode parent) {
		
	}*/
	
	@Override
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node<E> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> search(E key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> insert(E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> remove(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> getParent(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public Node<E> getLeftSibling(Node<E> current) {
		// TODO Auto-generated method stub
		return null;
	}

	public Node<E> getRightSibling(Node<E> current) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preOrder(Node<E> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inOrder(Node<E> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrder(Node<E> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelOrder(Node<E> node) {
		// TODO Auto-generated method stub

	}
}
