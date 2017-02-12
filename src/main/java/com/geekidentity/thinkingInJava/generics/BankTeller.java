package com.geekidentity.thinkingInJava.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.geekidentity.util.Generator;

class Customer {
	private static long counter = 1;
	private final long id = counter++;
	public Customer() {
	}
	@Override
	public String toString() {
		return "Customer " + id;
	}
	
	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			@Override
			public Customer next() {
				return new Customer();
			}
		};
	}
}

class Teller {
	private static long counter = 1;
	private final long id = counter++;
	@Override
	public String toString() {
		return "Teller " + id;
	}
	public static Generator<Teller> generator() {
		return new Generator<Teller>() {
			@Override
			public Teller next() {
				return new Teller();
			}
		};
	}
}
public class BankTeller {
	public static void serve(Teller teller, Customer customer) {
		System.out.println(teller + " serves" + customer);
	}
	
	public static void main(String[] args) {
		Random rand = new Random(47);
		Queue<Customer> line = new LinkedList<>();
		Generators.fill(line, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<>(5);
		Generators.fill(tellers, Teller.generator(), 4);
		for (Customer c : line) {
			serve(tellers.get(rand.nextInt(tellers.size())), c);
		}
	}
}
