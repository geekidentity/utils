package com.geekidentity.thinkingInJava.generics;

import java.util.Collection;

import com.geekidentity.util.Generator;

/**
 * 生成器（Generator）的辅助类
 * @Project: Utils
 * @Package: com.geekidentity.thinkingInJava.generics
 * @author: 侯法超
 * @date: 2016年10月10日  下午6:38:47
 * @version: V1.0
 *
 */
public class Generators {
	
	/**
	 * 能过生成器Generator将集合Collection进行填充。
	 * @param collection
	 * @param gen
	 * @param n
	 * @return
	 */
	public static <T> Collection<T> fill(Collection<T> collection, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++) {
			collection.add(gen.next());
		}
		return collection;
	}
}
