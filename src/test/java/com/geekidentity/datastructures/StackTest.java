package com.geekidentity.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<Integer> stack;
	private Random random = new Random();
	
	@Before
	public void init() {
		int size = 5;
		stack = new ArrayStack<Integer>(10);
		for (int i = 0; i < size; i++) {
			stack.push(random.nextInt(1000));
		}
	}
	
	@Test
	public void pushAndPop() {
		Integer num = random.nextInt();
		stack.push(num);
		assertEquals(num, stack.pop());
	}
	
	@Test
	public void manyPush() {
		for (int i = 0; i < 10000; i++) {
			stack.push(new Integer(i));
		}
		System.out.println(stack.size());
	}

}
