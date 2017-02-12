package com.geekidentity.thinkingInJava.generics;

import com.geekidentity.util.Generator;

public class CollectionData<T> {
	private Generator<T> generator;
	private int size;
	
	public CollectionData(Generator<T> gen, int length) {
		this.generator = gen;
		this.size = length;
	}

	public T[] toArray(T[] a) {
		return null;
	}

}
