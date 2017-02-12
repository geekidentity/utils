package com.geekidentity.datastructures;

/**
 * 线性表接口
 * @author 侯法超
 * @date  2016年9月23日  下午6:09:15
 *
 * @param <E>
 */
public interface List<E> {
	
	/**
	 * 将表的内容清除，成为空表。
	 */
	void clear();
	
	/**
	 * 返回当前实际长度
	 */
	int size();
	
	/**
	 * 在表尾添加元素
	 * @param element
	 * @return
	 */
	boolean add(final E element);
	
	/**
	 * 在位置p插入元素
	 * @param index
	 * @param element
	 * @return
	 */
	boolean add(int index, final E element);
	
	/**
	 * 删除位置p上的元素，并返回删除的元素
	 * @param index
	 * @return
	 */
	E remove(int index);
	
	/**
	 * 设置元素，并返回之前的元素
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index, E element);
	
	/**
	 * 返回元素
	 * @param index
	 * @return
	 */
	E get(int index);
	
	/**
	 * 查找value
	 * @param element
	 * @return value所在的位置
	 */
	int indexOf(E element);
	
	/**
	 * 是否含有
	 * @param o
	 * @return
	 */
	boolean contain(Object o);
}
