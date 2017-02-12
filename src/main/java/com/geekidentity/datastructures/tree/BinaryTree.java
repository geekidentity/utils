package com.geekidentity.datastructures.tree;

import com.geekidentity.datastructures.ArrayQueue;
import com.geekidentity.datastructures.ArrayStack;
import com.geekidentity.datastructures.Stack;

public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
	
	/**
	 * 二叉树根结点
	 */
	private Node<E> root;
	
	public BinaryTree(E element) {
		this.root = new BinaryTreeNode<E>(element);
	}
	
	public BinaryTree() {
		this(null);
	}
	
	/**
	 * 判断二叉树是否为空树
	 * @return
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * 返回根结点
	 * @return
	 */
	public Node<E>	getRoot() {
		return root;
	}
	
	/**
	 * 返回指定结点的左兄弟结点。
	 * @param current
	 * @return
	 */
	public Node<E> getLeftSibling(Node<E> current) {
		return null;
	}
	
	/**
	 * 返回指定结点的右兄弟结点
	 * @param current
	 * @return
	 */
	public Node<E> getRightSibling(Node<E> current) {
		return null;
	}
	
	/**
	 * 递归前序遍历二叉树或其子树。
	 * @param node 开始遍历的结点
	 */
	public void preOrderRecursion(Node<E> node) {
		if (node != null) {
			visit(node);
			preOrderRecursion(node.getLeftchild());
			preOrderRecursion(node.getRightchild());
		}
	}
	
	/**
	 * 前序遍历二叉树或其子树。非递归方法。
	 * 
	 * @param node 开始遍历的结点
	 */
	public void preOrder(Node<E> node) {
		/**
		 * 非递归遍历
		 * 遇到一个结点，就访问该结点，并把此结点的非空右结点推入栈中，然后下降去遍历其左子树。
		 * 遍历完左子树后，从栈顶托出一个结点，并按照它的右链接指示的地址再去遍历该结点的右子树结构。
		 */
		Stack<Node<E>> stack = new ArrayStack<Node<E>>();
		stack.push(null);//压入栈底监视哨。
		Node<E> root = node;
		while (root != null) {
			visit(root);//访问当前结点
			if (root.getRightchild() != null) {
				//右孩子入栈，等遍历完左子树后再遍历其右子树
				stack.push(root.getRightchild());
			}
			if (root.getLeftchild() != null) {
				//左路下降，访问根结点后访问左子树。
				root = root.getLeftchild();
			} else {
				//左子树访问完毕，访问右子树。
				root = stack.pop();
			}
		}
	}
	
	/**
	 * 递归中序遍历二叉树或其子树。
	 * @param node 开始遍历的结点
	 */
	public void inOrderRecursion(Node<E> node) {
		if (node != null) {
			inOrderRecursion(node.getLeftchild());
			visit(node);
			inOrderRecursion(node.getRightchild());
		}
	}
	
	/**
	 * 非递归中序遍历二叉树或其子树
	 * @param node 开始遍历的结点
	 */
	public void inOrder(Node<E> node) {
		/*
		 * 遇到一个结点，把它压入栈中，遍历其左子树。
		 * 遍历完左子树，从栈顶弹出该结点并访问，按照其右链地址遍历该结点的右子树。
		 */
		Stack<Node<E>> stack = new ArrayStack<>();
		Node<E> temp = node;
		while (temp != null || !stack.empty()) {
			if (temp != null) {
				//visit(temp);//前序访问点
				stack.push(temp);//当前结点地址入栈
				temp = temp.getLeftchild();//当前结点指向左孩子
			} else {
				//左子树访问完毕，转向访问右子树
				temp = stack.pop();
				visit(temp);//访问当前结点
				temp = temp.getRightchild();//当前结点指向右孩子
			}
		}
		
	}
	
	/**
	 * 递归后序遍历二叉树或其子树
	 * @param node 开始遍历的结点
	 */
	public void postOrderRecursion(Node<E> node) {
		if (node != null) {
			postOrderRecursion(node.getLeftchild());
			postOrderRecursion(node.getRightchild());
			visit(node);
		}
	}
	
	/**
	 * 后序遍历二叉树或其子树
	 * @param node 开始遍历的结点
	 */
	public void postOrder(Node<E> node) {
		/*
		 * 
		 */
		StackElement element = new StackElement();
		Stack<StackElement> stack = new ArrayStack<>();
		Node<E> temp = node;
		while (!stack.empty() || temp != null) {
			//沿非空指针压栈，并一直沿着左路下滑
			while (temp != null) {
				element.node = temp;
				element.tag = Tags.Left;
				stack.push(element);//把标志位为Left的结点压入栈
				temp = temp.getLeftchild();
			}
			//把所有的左结点压入栈后，获得栈顶元素
			element = stack.pop();
			temp = element.node;
			if (element.tag == Tags.Left) {
				/*
				 * 如果是从左子树返回的，则置标志位为Right，并压入栈，将来从右边返回才能访问。
				 */
				element.tag = Tags.Right;
				stack.push(element);
				temp = temp.getRightchild();
			} else {
				/*
				 * 如果从右子树返回，说明访问完全成，则访问该结点。
				 */
				visit(temp);
				temp = null;//循环时用。
			}
		}
	}
	
	/*
	 * 标志位，说明后序遍历是从左边返回还是从右边返回。
	 */
	enum Tags {
		//表示已经进入该结点的左子树，将从左边回来。
		Left,
		//表示已经进入该结点的右子树，将从右边回来。
		Right,
	}
	
	/**
	 * 后序遍历中的栈元素
	 * @Project: Utils
	 * @Package: com.geekidentity.datastructures.tree
	 * @author: 侯法超
	 * @date: 2016年10月8日  下午7:29:01
	 * @version: V1.0
	 *
	 */
	private class StackElement {
		//指向二叉树结点的指针
		Node<E> node;
		//标志位
		Tags tag;
	}
	
	/**
	 * 后序遍历栈中的元素，记录是左还是右子树
	 * @author 侯法超
	 * @date  2016年9月27日  下午8:25:46
	 *
	 */
	
	
	/**
	 * 层次遍历二叉树或其子树。
	 * 从二叉树的第0层（根结点）开始，自上至下逐层遍历，在同一层中，按照从左到右的顺序对结点逐一访问。
	 * @param root
	 */
	public void levelOrder(Node<E> root) {
		ArrayQueue<Node<E>> queue = new ArrayQueue<>(10);
		//保存输入参数
		Node<E> node = root;
		if (node != null) {
			//保存根结点入队列
			queue.add(node);
		}
		while (!queue.isEmpty()) {
			//取队列首结点
			node = queue.remove();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
			//访问当前结点
			visit(node);
			if (node.getLeftchild() != null) {
				//左子树入队
				queue.add(node.getLeftchild());
			}
			if (node.getRightchild() != null) {
				//右子树入队
				queue.add(node.getRightchild());
			}
		}
	}
	
	/**
	 * 删除二叉树或其子树
	 * @param root
	 */
	public void deleteBinaryTree(Node<E> root) {
		
	}
	
	/**
	 * 递归搜索指定结点的父结点
	 * @param root
	 * @param current 要找的结点
	 * @return
	 */
	public BinaryTreeNode<E> getParent(BinaryTreeNode<E> root, BinaryTreeNode<E> current) {
		BinaryTreeNode<E> t = null;
		if (root == null) {
			return null;
		}
		//如果孩子是current则返回root
		if (current == root.getLeftchild() || current == root.getRightchild()) {
			return root;
		}
		//递归查找左子树
		if ((t = getParent((BinaryTreeNode<E>) root.getLeftchild(), current)) != null) {
			return t;
		}
		//递归查找右子树
		if ((t = getParent((BinaryTreeNode<E>) root.getRightchild(), current)) != null) {
			return t;
		}
		return null;
	}
	
	/**
	 * 非递归找父结点，前序
	 * @param root
	 * @param current
	 * @return
	 */
	public Node<E> getParent2(Node<E> root, Node<E> current) {
		Stack<Node<E>> stack = new ArrayStack<>();
		Node<E> node = root;
		//栈底监视哨
		stack.push(null);
		while (node != null) {
			//如果node的孩子是current，则返回
			if (current == node.getLeftchild() || current == node.getRightchild()) {
				return node;
			}
			//非空右孩子入栈
			if (node.getRightchild() != null) {
				stack.push(node.getRightchild());
			}
			//左路下降
			if (node.getLeftchild() != null) {
				node = node.getLeftchild();
			} else {//左子树访问完毕，转向访问右子树
				node = stack.pop();
			}
		}
		return null;
	}
	
	/**
	 * 访问指定结点
	 * @param node
	 */
	private void visit(Node<E> node) {
		System.out.println(node.getElement());
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

	/**
	 * 返回指定结点的父结点。
	 */
	@Override
	public Node<E> getParent(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		this.root = new BinaryTreeNode<E>(element, leftTree == null?null:leftTree.getRoot(),
				rightTree == null ? null : rightTree.getRoot());
	}
}
