package com.geekidentity.thinkingInJava.generics;

public class LinkedStack<T> {
	private static class Node<E> {
		E item;
		Node<E> next;
		public Node() {
			item = null;
			next = null;
		}
		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
		boolean end() {
			return item == null && next == null;
		}
	}
	private Node<T> top = new Node<T>();//End sentinel
	
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phares or stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s = lss.pop())!=null) {
			System.out.println(s);
		}
	}
}
