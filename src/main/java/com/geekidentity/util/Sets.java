package com.geekidentity.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Set数学中并、交、补、等运算
 * @Project: Utils
 * @Package: com.geekidentity.util
 * @author: 侯法超
 * @date: 2016年10月10日  下午4:04:13
 * @version: V1.0
 *
 */
public class Sets {
	
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<>(superset);
		result.removeAll(subset);
		return result;
	}
	
	/**
	 * 除了交集以外的所有元素。
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
}
