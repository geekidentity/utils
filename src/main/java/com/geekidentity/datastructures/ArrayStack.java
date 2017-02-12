package com.geekidentity.datastructures;

public class ArrayStack<E> implements Stack<E> {
	
	//当前顺序栈中最大容量
	private int maxSize;
	
	//栈顶所在位置，同时也可以说明当前栈的大小
	private int top;
	
	//存放元素
	private Object[] stack;
	
	/**
	 * 顺序栈默认构造函数，默认大小为10
	 */
	public ArrayStack() {
		this(10);
	}
	
	/**
	 * 构造指定容量大小的栈
	 * @param size
	 */
	public ArrayStack(int size) {
		stack = new Object[size];
		maxSize = size;
		top = -1;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i <= top; i++) {
			stack[i] = null;
		}
		top = -1;
	}

	/**
	 * 压入栈，上溢问题
	 */
	@Override
	public E push(E e) {
		if (top == maxSize-1) {
			maxSize *= 2;
			Object [] newStack = new Object[maxSize];
			System.arraycopy(stack, 0, newStack, 0, top);
			stack = newStack;
		}
		stack[++top] = e;
		return e;
	}

	/**
	 * 出栈，下溢问题
	 */
	@Override
	public E pop() {
		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException(-1);
		}
		E e = stack();
		stack[top--] = null;
		return e;
	}

	@Override
	public E peek() {
		return stack();
	}

	@Override
	public boolean empty() {
		return top==-1?true:false;
	}

	@Override
	public int search(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//*********************************************************
	
	@SuppressWarnings("unchecked")
	E stack() {
		return (E) stack[top];
	}

	@Override
	public int size() {
		return top + 1;
	}

}
