package com.geekidentity.util;

/**
 * 一个通用的Generator，为任何类构造一个Generator，只要该类具有默认的构造器。
 * @Project: Utils
 * @Package: com.geekidentity.util
 * @author: 侯法超
 * @date: 2016年10月10日  下午3:30:07
 * @version: V1.0
 *
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
	
	private Class<T> type;
	
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}

	@Override
	public T next() {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 给定类型生成一个默认的生成器
	 * @param type
	 * @return
	 */
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}

}
