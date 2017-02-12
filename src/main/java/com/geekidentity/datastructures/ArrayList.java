package com.geekidentity.datastructures;

/**
 * 顺序表类
 * @author 侯法超
 * @date  2016年9月23日  下午6:20:32
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
	
	//存储顺序表的实例
	private Object []elementData;
	
	//顺序表中实例最大长度
	private int maxSize;
	
	//当前长度
	private int size;
	
	/**
	 * 空实例的共享数组
	 */
	private static final Object [] EMPTYELEMENTDATA = {};
	
	/**
	 * 创建新的表，设置元素最大数量
	 * @param size
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			elementData = new Object[initialCapacity];
			maxSize = initialCapacity;
		} else if (initialCapacity == 0) {
			elementData = EMPTYELEMENTDATA;
		} else {
			throw new IllegalArgumentException("非法的数组初始化参数：" + initialCapacity);
		}
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E value) {
		elementData[size++] = value;
		return true;
	}

	@Override
	public boolean add(int index, E value) {
		if (size >= maxSize) {
			throw new IllegalArgumentException("参数超出最大空间大小");
		}
		if (index<0 || index>size) {
			throw new IllegalArgumentException("Illegal index:" + index);
		}
		
		for (int i = size; i > index ; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = value;
		size++;
		return true;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E oldValue = elementData(index);
		int numMoved = size - index - 1;
		System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--size] = null;
		return oldValue;
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	@Override
	public E get(int index) {
		return elementData(index);
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i]==null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean contain(Object o) {
		return indexOf(o) >= 0;
	}
	
	//****************************************************
	
	/**
	 * 取出指定元素，并返回泛型类型。
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}
	
	private void rangeCheck(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
	}
}
