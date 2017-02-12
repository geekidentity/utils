package com.geekidentity.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeImpl<E> implements Tree<E> {

	private TreeNode<E> root;

	@Override
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 返回树的根结点
	 */
	@Override
	public Node<E> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 创建值为rootValue的根结点
	 * @param rootValue
	 */
	public void createRoot(E rootValue) {
		
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

	/**
	 * 寻找当前结点父指针
	 * @param current
	 * @return
	 */
	public Node<E> getParent(Node<E> current) {
		/*
		 * 用宽搜寻找当前结点父结点
		 */
		Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
		TreeNode<E> pointer = root;
		TreeNode<E> father = null;//记录父结点
		TreeNode<E> upperLevelPointer = null;
		if (current != null && pointer != null) {
			/*
			 * 森林中所有根结点进队列
			 */
			while (pointer != null) {
				if (current == pointer) {//森林中所有第一层根的父为空
					break ;
				}
				queue.add(pointer);//当前结点进队列
				pointer = (TreeNode<E>) pointer.getRightSibling();//指针指向右
			}
			while (!queue.isEmpty()) {
				pointer = queue.poll();//取队列首结点指针
				upperLevelPointer = pointer;//指向上一层的结点
				pointer = (TreeNode<E>) pointer.getLeftMostChild();//指向最左孩子
				while (pointer != null) {
					if (current == pointer) {
						father = upperLevelPointer;
						break ;
					} else {
						queue.add(pointer);
						pointer = (TreeNode<E>) pointer.getRightchild();
					}
				}
			}
		}
		return father;
	}
	
	/**
	 * 返回前一个兄弟
	 * @param current
	 * @return
	 */
	public Node<E> getPrevSibling(Node<E> current) {
		return null;
	}
	
	/**
	 * 删除以subRoot子树
	 * @param subRoot
	 */
	public void deleteSubTree(Node<E> subRoot) {
		
	}
	
	/**
	 * 先根深度优先遍历树
	 * @param root
	 */
	public void rootFirstTraverse(Node<E> root) {
		TreeNode<E> rt = (TreeNode<E>)root;
		while (rt != null) {
			visit(rt);//访问当前结点
			//遍历第一棵树根的子树森林（树根除外）
			rootFirstTraverse(rt.getLeftMostChild());
			rt = (TreeNode<E>) rt.getRightSibling();//遍历其他树
		}
	}
	
	/**
	 * 后根深度优先遍历树
	 * @param root
	 */
	public void rootLastTraverse(Node<E> root) {
		TreeNode<E> rt = (TreeNode<E>) root;
		while (rt != null) {
			//遍历第一棵树根的子树森林
			rootLastTraverse(rt.getLeftMostChild());
			visit(rt);//访问当前结点
			rt = (TreeNode<E>) rt.getRightSibling();//遍历其他树
		}
	}
	
	/**
	 * 广度优先遍历树
	 * @param root
	 */
	public void widthTraverse(Node<E> root) {
		Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
		TreeNode<E> pointer = (TreeNode<E>) root;
		
		while (pointer != null) {
			queue.add(pointer);//当前结点进入队列
			pointer = (TreeNode<E>) pointer.getRightSibling();//pointer指向右兄弟
		}
		while (!queue.isEmpty()) {
			pointer = queue.poll();//获得队首元素
			visit(pointer);
			pointer = (TreeNode<E>) pointer.getLeftMostChild();//pointer指向最左孩子
			while (pointer != null) {
				queue.add(pointer);
				pointer = (TreeNode<E>) pointer.getRightSibling();
				
			}
			
		}
	}
	
	private void visit(Node<E> root) {
		System.out.println(root.getElement());
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
