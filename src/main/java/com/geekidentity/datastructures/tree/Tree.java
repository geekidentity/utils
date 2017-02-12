package com.geekidentity.datastructures.tree;

/**
 * 
 * @Title: Tree.java
 * @Project: Utils
 * @Package: com.geekidentity.datastructures.tree
 * @Description: TODO
 * @author: 侯法超
 * @date: 2016年9月30日  上午10:52:29
 * @version: V1.0
 *
 * @param <E>
 */
public interface Tree<E> {
	
	/**
	 * 给定一个元素创建一个树
	 * @param element
	 * @param leftTree
	 * @param rightTree
	 */
	void create(E element, Tree<E> leftTree, Tree<E> rightTree);
	
	/**
	 * 判断是否是一棵空树
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 返回根结点
	 * @return
	 */
	Node<E> getRoot();
	
	/**
	 * 搜索指定元素
	 * @param key
	 * @return
	 */
	Node<E> search(E key);
	
	/**
	 * 将元素插入
	 * @param value
	 * @return
	 */
	Node<E> insert(E value);
	
	/**
	 * 删除指定元素的结点
	 * @param element
	 * @return
	 */
	Node<E> remove(E element);
	
	/**
	 * 获取指定元素的父结点
	 * @param element
	 * @return
	 */
	Node<E> getParent(E element);
	
	/**
	 * 前序遍历二叉树或其子树。
	 * @param node
	 */
	void preOrder(Node<E> node);
	
	/**
	 * 中序遍历二叉树或其子树。
	 * @param node
	 */
	void inOrder(Node<E> node);
	
	/**
	 * 后序遍历二叉树或其子树。
	 * @param node
	 */
	void postOrder(Node<E> node);
	
	/**
	 * 层次遍历二叉树或其子树。
	 * @param node
	 */
	void levelOrder(Node<E> node);
}
