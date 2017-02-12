package com.geekidentity.test;

import java.util.Random;

class Initable {
	static final int staticFianl = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNotFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNotFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException {
		Class<Initable> initable = Initable.class;
		System.out.println("after create Initable ref");
		System.out.println(Initable.staticFianl);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNotFinal);
		Class<?> initable3 = Class.forName("com.geekidentity.test.Initable3");
		System.out.println("after create Initable3 ref");
		System.out.println(Initable3.staticNotFinal);
	}
}
