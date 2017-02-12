package com.geekidentity.thinkingInJava.generics.coffee;

import java.util.Iterator;
import java.util.Random;

import com.geekidentity.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	
	private Class<?>[] type = {Latte.class, Mocha.class, 
			Cappuccino.class, Americano.class, Breve.class,};
	private static Random rand = new Random(47);
	private int size;
	public CoffeeGenerator() {}
	
	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee) type[rand.nextInt(type.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count --;
			return CoffeeGenerator.this.next();
		}
	}
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	public static void main(String[] args) {
		CoffeeGenerator generator = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(generator.next());
		}
		for (Coffee coffee : new CoffeeGenerator(5)) {
			System.out.println(coffee);
		}
	}
}
