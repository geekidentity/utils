package com.geekidentity.thinkingInJava;

import java.io.PrintStream;
import java.util.Formatter;

public class FomatterTest {
	public static void main(String[] args) {
		//testFomatter();
		Formatter f = new Formatter(System.out);
		char u = 'u';
		System.out.println("u = " + u);
		f.format("s: %s\n", u);
		//f.format("d: %d\n", u);
		f.close();
	}

	public static void testFomatter() {
		PrintStream outAlias = System.err;
		Turtle tommy = new Turtle("tommy", new Formatter(outAlias));
		Turtle mark = new Turtle("mark", new Formatter(outAlias));
		tommy.move(2, 2);;
		mark.move(4, 2);
	}
}

class Turtle {
	private String name;
	private Formatter formatter;
	public Turtle(String name, Formatter formatter) {
		this.name = name;
		this.formatter = formatter;
	}
	
	public void move(int x, int y) {
		formatter.format("%s The turtle at(%d, %d)\n", name, x, y);
	}
}