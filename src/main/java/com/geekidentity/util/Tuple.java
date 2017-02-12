package com.geekidentity.util;

import com.geekidentity.thinkingInJava.generics.TwoTuple;

public class Tuple {
	public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
		return new TwoTuple<A, B>(a, b);
	}
	
}
