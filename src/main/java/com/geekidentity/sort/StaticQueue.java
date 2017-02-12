package com.geekidentity.sort;

public class StaticQueue {
	private int head;
	private int next;
	
	/**
	 * 
	 * @param array
	 * @param d
	 * @param r
	 */
	public void sort(int[] array, int d, int r) {
		
	}
	
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
}

class Node {
	private int key;
	private int next;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	
	
}