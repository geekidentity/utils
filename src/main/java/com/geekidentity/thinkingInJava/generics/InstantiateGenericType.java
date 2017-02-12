package com.geekidentity.thinkingInJava.generics;

class ClassAsFactory<T> {
	T x;
	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

class Employee {}

public class InstantiateGenericType {
	public static void main(String[] args) {
		new ClassAsFactory<Employee>(Employee.class);
		System.out.println("ClassAsFactory<Employee> succeeded");
		try {
			new ClassAsFactory<Integer>(Integer.class);
		} catch (Exception e) {
			System.out.println("ClassAsFactory<Employee> failed");
		}
	}
}
