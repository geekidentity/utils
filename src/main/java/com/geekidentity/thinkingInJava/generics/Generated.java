package com.geekidentity.thinkingInJava.generics;

import java.lang.reflect.Array;

import com.geekidentity.util.Generator;

public class Generated {
	public static <T> T[] array(T[] a, Generator<T> gen) {
		return new CollectionData<T>(gen, a.length).toArray(a);
	}
	
	public static <T> T[] array(Class<T> type,
			Generator<T> generator, int size) {
		@SuppressWarnings("unchecked")
		T[] a = (T[]) Array.newInstance(type, size);
		return new CollectionData<T>(generator, size).toArray(a);
	}
}
