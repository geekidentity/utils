package com.geekidentity.test;

class Base{}

class Derived extends Base {}

public class FamilyVsExactType {
	static void test(Object x) {
		System.out.println("Testing x of type " + x.getClass());
		System.out.println("x instanceof Base " + (x instanceof Base));
		System.out.println("x instanceof Derived " + (x instanceof Derived));
		System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
	}
	
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
}
