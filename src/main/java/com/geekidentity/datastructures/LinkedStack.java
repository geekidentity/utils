package com.geekidentity.datastructures;

public class LinkedStack<E> implements Stack<E> {
	
	private int size;
	private Node top = new Node();//栈底监视哨
	
	private class Node {
		E item;
		Node next;
		public Node() {
			item = null;
			next = null;
		}
		public Node(E item, LinkedStack<E>.Node next) {
			this.item = item;
			this.next = next;
		}
		boolean end() {
			return item==null && next== null;
		}
	}

	@Override
	public E push(E item) {
		top = new Node(item, top);
		size ++;
		return item;
	}

	@Override
	public E pop() {
		E result = top.item;
		if (!top.end()) {
			top = top.next;
			size --;
		}
		return result;
	}

	@Override
	public E peek() {
		return top.item;
	}

	@Override
	public boolean empty() {
		return top.end();
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int size() {
		return size;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
