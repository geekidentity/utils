package com.geekidentity.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.Random;

import com.geekidentity.util.Generator;

class Product {
	private final int id;
	private String description;
	private double price;
	public Product(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return id + ": " + description + ", price: $" + price;
	}
	
	public void priceChange(double change) {
		price += change;
	}
	
	public static Generator<Product> generator = new Generator<Product>() {
		private Random rand = new Random(47);
		@Override
		public Product next() {
			return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0)+0.99);
		}
	};
}

class Shelf extends ArrayList<Product> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Shelf(int nProduct) {
		Generators.fill(this, Product.generator,nProduct);
	}
}

class Aisle extends ArrayList<Shelf> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7834792414011251598L;
	
}
public class Store {
	
}
