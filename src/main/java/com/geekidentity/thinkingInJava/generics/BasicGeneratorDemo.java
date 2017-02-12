package com.geekidentity.thinkingInJava.generics;

import com.geekidentity.util.BasicGenerator;
import com.geekidentity.util.Generator;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CountedObject> generator = BasicGenerator.create(CountedObject.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(generator.next());
		}
	}
}
