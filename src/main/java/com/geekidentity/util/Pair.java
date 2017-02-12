package com.geekidentity.util;

/**
 * 这个类为组装Map用的，key和value都是public final的，
 * 这是为了使Pair成为只读的数据传输对象（信使）
 * @author: 侯法超
 * @date: 2016年11月11日  下午2:59:50
 * @version: V1.0
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {
	public final K key;
	public final V value;
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
