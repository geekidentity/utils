package com.geekidentity.util;

import java.util.LinkedHashMap;

/**
 * Map初始化对象
 * @author: 侯法超
 * @date: 2016年11月11日  下午3:22:42
 * @version: V1.0
 *
 * @param <K>
 * @param <V>
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 5301783443989284256L;
	
	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}
	
	public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), genV.next());
		}
	}
	
	/**
	 * A key Generator and a single value
	 */
	public MapData(Generator<K> genK, V value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), value);
		}
	}
	
	/**
	 * An Iterable and a value Generator
	 * @param genK
	 * @param value
	 */
	public MapData(Iterable<K> genK, V value) {
		for (K k : genK) {
			put(k, value);
		}
	}
	
}
