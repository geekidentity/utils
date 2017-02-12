package com.geekidentity.datastructures.tree;

/**
 * 基于数组的最大堆
 * @Project: Utils
 * @Package: com.geekidentity.datastructures.tree
 * @author: 侯法超
 * @date: 2016年10月20日  下午6:17:51
 * @version: V1.0
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> implements Tree<E> {

	private Object[] heapArray;
	private int size;
	private int maxSize;
	
	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		heapArray = new Object[maxSize];
	}
	
	
	
	public MaxHeap(E[] array) {
		this.heapArray = array;
		this. maxSize = this.size = array.length;
		for (int i = 0; i < heapArray.length; i++) {
			siftDown(i);
		}
	}



	@Override
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 从position向上开始调整，使序列成为最大堆
	 * @param position
	 */
	public void siftUp(int position) {
		int tempPosition = position;//从position向上开始调整，使序列成为堆
		//
		E temp = heap(tempPosition);
		while (tempPosition > 0 && temp.compareTo(parent(tempPosition)) > 0) {
			heapArray[tempPosition] = heapArray[tempPosition/2-1];
			tempPosition = tempPosition/2-1;
		}
		heapArray[tempPosition] = temp;
	}
	
	@SuppressWarnings("unchecked")
	protected E parent(int tempPosition) {
		return (E) heapArray[tempPosition/2-1];
	}



	/**
	 * 从position向下开始调整，使序列成为最大堆
	 * @param position
	 */
	public void siftDown(int position) {
		int i = position;//标识父结点
		int j = position*2 + 1;//默认标识左孩子结点
		@SuppressWarnings("unchecked")
		E temp = (E) heapArray[i];//保存父结点元素
		
		while (j < size) {
			if (j < size-1 && temp.compareTo(heap(j + 1)) < 0) {
				j++;//j指向数值较大的子结点
			}
			if (temp.compareTo(heap(j)) < 0) {
				heapArray[i] = heapArray[j];
				i = j;
				j = i*2 + 1;//向下继续
			} else {
				break;
			}
		}
		heapArray[i] = temp;
		
	}
	
	@SuppressWarnings("unchecked")
	private E heap(int j) {
		return (E) heapArray[j];
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


	/**
	 * 删除最大值。
	 * 本质并没有进行删除，只是把最大的值放到了当前堆最后一个，然后size--
	 */
	public E removeMax() {
		E result = heap(0);
		heapArray[0] = heapArray[--size];
		siftDown(0);
		return result;
	}

}
