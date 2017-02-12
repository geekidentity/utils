package com.geekidentity.datastructures.tree;

import java.util.List;

/**
 * 二叉搜索树，左小右大
 * @Title: BinarySearchTree.java
 * @Project: Utils
 * @Package: com.geekidentity.datastructures.tree
 * @Description: 二叉搜索树(BST)实现
 * @author: 侯法超
 * @date: 2016年10月1日  下午4:48:31
 * @version: V1.0
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {
	/*
	 * 根结点
	 */
	private Node<E> root;

	public BinarySearchTree(List<E> list) {
		for (E e : list) {
			insert(e);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Node<E> getRoot() {
		return root;
	}

	/**
	 * 查找指定元素
	 * 1：从root结点开始；
	 * 2：比当前结点值小，则查找其左结点；
	 * 3：比当前结点值大，则查找其右结点；
	 * 4：如果与当前结点值相等，查找成功，返回当前结点；
	 * 5：查找完毕没有找到，返回 null。
	 * @param key 不能为 null
	 * @return 如果查找成功返回元素所在结点，否则返回null
	 */
	@Override
	public Node<E> search(E key) {
		Node<E> current = root;
		while (current != null) {
			if (key.compareTo(current.getElement()) > 0) {
				current = current.getRightchild();
			} else if(key.compareTo(current.getElement()) < 0) {
				current = current.getLeftchild();
			} else {
				break;
			}
		}
		return current;
	}

	/**
	 * 将指定元素插入BST
	 * 1：从root结点开始；
	 * 2：如果root值为空，则root为插入值；
	 * 循环
	 * 3：当前结点值大于插入值，找右结点；
	 * 4：如果当前值小于插入值，找左结点。
	 * @param element
	 * @return
	 */
	@Override
	public Node<E> insert(E element) {
		Node<E> node = root;
		if (root == null) {
			root = new BinaryTreeNode<E>(element);
		} else {
			while (node != null) {
				if (element.compareTo(node.getElement()) > 0) {
					node = node.getRightchild();
				} else {
					node = node.getLeftchild();
				}
			}
			node = new BinaryTreeNode<E>(element);
		}
		return node;
	}

	@Override
	public Node<E> remove(E value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * BST删除，（值替换）
	 * @param rt
	 * @param value
	 */
	void remove(Node<E> rt, E value) {
		//首先，找到待删结点
		if (rt == null) {
			System.out.println("is not a tree");
		} else if (value.compareTo(rt.getElement()) < 0) {
			remove(rt.getLeftchild(), value);
		} else if (value.compareTo(rt.getElement()) > 0) {
			remove(rt.getRightchild(), value);
		} else { //相等，找到元素，删除
			Node<E> temp = rt;
			//如果左孩子为空，直挂将右孩子替换上来
			if (rt.getLeftchild() == null) {
				rt = rt.getRightchild();
			} else if (rt.getRightchild() == null) {
				rt = rt.getLeftchild();
			} else {
				temp = deletemin(rt.getRightchild());
				rt.setElement(temp.getElement());
			}
			temp = null;
		}
	}

	/*
	 * 找到rt右子树中最小结点，并删除
	 */
	private Node<E> deletemin(Node<E> node) {
		if (node.getLeftchild() != null) {
			return deletemin(node.getLeftchild());
		} else {//找到右子树中最小的，删除
			Node<E> temp = node;
			node = node.getRightchild();
			return temp;
		}
	}

	@Override
	public Node<E> getParent(E element) {
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
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preOrder(Node<E> node) {
		while (node != null) {
			visit(node);
			preOrder(node.getLeftchild());
			preOrder(node.getRightchild());
		}
	}

	private void visit(Node<E> node) {
		System.out.println(node.getElement());
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
	
	/**
	 * @return 当前二叉树中最大的元素
	 */
	public E getMax() {
		Node<E> node = root;
		while (node != null) {
			if (node.getRightchild() == null) {
				return node.getElement();
			}
		}
		return null;
	}
	
	/**
	 * @return 当前二叉树中最小的元素
	 */
	public E getMin() {
		Node<E> node = root;
		while (node != null) {
			if (node.getLeftchild() == null) {
				return node.getElement();
			}
		}
		return null;
	}
	
	
}
