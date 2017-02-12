package com.geekidentity.datastructures;

public interface Stack<E> {

	/**
	 * 把项压入堆栈顶部。
	 * @param item
	 * @return
	 */
	E push(E item);
	/**
	 * 移除堆栈顶部的对象，并作为此函数的值返回该对象
	 * @return
	 */
	E pop();
	/**
	 * 查看堆栈顶部的对象，但不从堆栈中移除它。 
	 * @return
	 */
	E peek();
	/**
	 * 测试堆栈是否为空。
	 * @return
	 */
	boolean empty();
	/**
	 * 返回对象在堆栈中的位置，以 1 为基数。如果对象 o 是堆栈中的一个项，
	 * 此方法返回距堆栈顶部最近的出现位置到堆栈顶部的距离；堆栈中最顶部项的距离为 1。
	 * 使用 equals 方法比较 o 与堆栈中的项。
	 * @param o
	 * @return
	 */
	int search(Object o);
	/**
	 * 当前栈的大小
	 * @return
	 */
	int size();
	/**
	 * 清空栈
	 */
	void clear();
}
