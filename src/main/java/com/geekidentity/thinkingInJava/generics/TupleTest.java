package com.geekidentity.thinkingInJava.generics;

class Amphibian {}
class Vehicle {}

public class TupleTest {
	static TwoTuple<String, Integer> f() {
		return new TwoTuple<String, Integer>("hi", 47);
	}
	static ThreeTuple<Amphibian, String, Integer> g() {
		return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(), "geek", 48);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(g());
	}
}
