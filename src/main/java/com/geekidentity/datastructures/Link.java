package com.geekidentity.datastructures;

/**
 * 链表
 * @author 侯法超
 * @date  2016年9月24日  下午5:35:23
 *
 * @param <E>
 */
public class Link<E> implements List<E> {
	
	private Node<E> first;
	private Node<E> last;
	private int size;

	@Override
	public void clear() {
		for(Node<E> x = first; x != null;) {
			Node<E> next = x.next;
			x.item = null;
			x.prev = null;
			x.next = null;
			x = next;
		}
		first = null;
		last = null;
		size = 0;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<E>(l, e, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		checkPositionIndex(index);
		if (index == size) {
			add(e);
		} else {
			linkBefore(e, node(index));
		}
		return true;
	}

	@Override
	public E remove(int index) {
		checkElementIndex(index);
		return unlink(node(index));
	}

	@Override
	public E set(int index, E element) {
		checkElementIndex(index);
		Node<E> x = node(index);
		E oldValue = x.item;
		x.item = element;
		return oldValue;
	}

	@Override
	public E get(int index) {
		checkElementIndex(index);
		return node(index).item;
	}

	@Override
	public int indexOf(E element) {
		int index = 0;
		Node<E> node = first;
		while (node.next != null) {
			if (element.equals(node.item)) {
				return index;
			}
			index++;
			node = node.next;
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contain(Object o) {
		return indexOf((E)o) >= 0;
	}
	
	// Utils ************************************************
	
	/**
	 * 返回指定位置的Node
	 */
	Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<E> x = last;
			for (int i = size-1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}
	
	/**
	 * 用于构造一个IndexOutOfBoundsException详细信息
	 * @param index
	 * @return
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}
	
	private void checkElementIndex(int index) {
		if (!isElementIndex(index)) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	/**
	 * 确实是否是已存在元素的索引
	 * @param index
	 * @return
	 */
	private boolean isElementIndex(int index) {
		return index >=0 && index < size;
	}
	
	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size;
	}
	
	/**
	 * 删除指定非空结点
	 * @param x
	 * @return
	 */
	E unlink(Node<E> x) {
		final E element = x.item;
		final Node<E> next = x.next;
		final Node<E> prev = x.prev;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}
		
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}
		
		x.item = null;
		size--;
		return element;
	}
	
	/**
	 * 将 e 作为最后一个元素
	 * @param e
	 */
	void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newLast = new Node<E>(l, e, null);
		last = newLast;
		if (l == null) {
			first = newLast;
		} else {
			l.next = newLast;
		}
		size++;
	}
	
	/**
	 * 在结点 succ之前插入非空元素e。
	 * @param e
	 * @param succ
	 */
	void linkBefore(E e, Node<E> succ) {
		final Node<E> prev = succ.prev;
		final Node<E> newNode = new Node<E>(prev, e, succ);
		
		succ.prev = newNode;
		if (prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		
		size++;
	}
	
	//*****************************************
	
	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;
		
		Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
	}
	
}
