package com.geekidentity.util;

/**
 * 生成器（Generator），是一种专门负责创建对象的类。
 * 实际上，这是工厂方法设计模式的一种应用。不过，当使用生成器创建新的对象时，
 * 它不需要任何参数，而工厂方法一般需要参数。也就是说，生成器无需额外的信息
 * 就知道如何创建对象。
 * @Project: Utils
 * @Package: com.geekidentity.util
 * @author: 侯法超
 * @date: 2016年10月8日  上午10:21:21
 * @version: V1.0
 *
 * @param <T>
 */
public interface Generator<T> {
	/**
	 * 用来产生新的对象
	 * @return
	 */
	T next();
}
