package com.geekidentity.datastructures.tree;

/**
 * 基于数组的最小堆
 * @Project: Utils
 * @Package: com.geekidentity.datastructures.tree
 * @author: 侯法超
 * @date: 2016年10月19日  下午2:36:15
 * @version: V1.0
 *
 * @param <E>
 */
public class MinHeap<E extends Comparable<E>> implements Tree<E> {
	
	private Object[] heapArray;
	private int size;
	private int maxSize;
	
	/**
	 * 
	 * @param maxSize 最大元素数目
	 */
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		heapArray = new Object[maxSize];
	}
	
	/**
	 * 根据给定的数组建立最小堆
	 * @param array
	 */
	public MinHeap(E[] array) {
		this.heapArray = array;
		for (int i = 0; i < heapArray.length; i++) {
			siftDown(i);
		}
		this.maxSize = this.size = array.length;
	}

	@Override
	public void create(E element, Tree<E> leftTree, Tree<E> rightTree) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 建立最小堆
	 */
	public void buildHeap() {
		//反复调用筛选函数
		for (int i = size/2-1; i >= 0; i--) {
			siftDown(i);
		}
	}
	
	/**
	 * 从堆顶删除最小值
	 * @return
	 */
	public E removeMin() {
		E result = heap(0);
		heapArray[0] = heapArray[--size];
		siftDown(0);
		return result;
	}
	
	/**
	 * 从position向上开始调整，使序列成为最小堆
	 * @param position
	 */
	public void siftUp(int position) {
		int tempPosition = position;//从position向上开始调整，使序列成为堆
		//不是父结点直接swap
		E temp = heap(tempPosition);
		while (tempPosition > 0 && temp.compareTo(parent(tempPosition)) < 0) {
			heapArray[tempPosition] = heapArray[tempPosition/2];
			tempPosition = tempPosition/2-1;
		}
		heapArray[tempPosition] = temp;//找到最终位置
	}
	
	@SuppressWarnings("unchecked")
	protected E parent(int position) {
		return (E) heapArray[position/2-1];
	}

	/**
	 * 从position向下开始调整，使序列成为最小堆
	 * @param position
	 */
	public void siftDown(int position) {
		int i = position;//标识父结点
		int j = position*2 + 1;//默认标识左子孩子结点
		@SuppressWarnings("unchecked")
		E temp = (E) heapArray[i];//保存父结点
		
		while (j < size) {
			if (j < size && heap(j).compareTo(heap(j+1))>0 ) {
				j++;//j指向数值较小的子结点
			}
			if (temp.compareTo(heap(j)) > 0) {
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
	protected E heap(int i) {
		return (E) heapArray[i];
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
		if (size == maxSize) {
			return null;
		}
		heapArray[size] = value;
		siftUp(size);
		size++;
		return null;
	}

	public boolean remove(int position, E element) {
		if (position < 0 || position >= size) {
			return false;
		}
		heapArray[position] = heapArray[--size];
		if (heap(position).compareTo(parent(position)) > 0) {
			siftDown(position);
		} else {
			siftUp(position);
		}
		
		return true;
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
	 * 数组中指定位置是否是叶子结点
	 * @param position
	 * @return
	 */
	public boolean isLeaf(int position) {
		return false;
	}
}
