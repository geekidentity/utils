package com.geekidentity.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class LinkTest {
	
	private Link<Integer> link;
	private Random random;
	@Before
	public void init() {
		link = new Link<>();
		random = new Random();
		int size = 5;
		for (int i = 0; i < size; i++) {
			link.add(random.nextInt(100));
		}
		assertEquals(size, link.size());
	}
	
	@Test
	public void add() {
		Integer num = random.nextInt(100);
		int index = 3;
		link.add(index, num);
		assertEquals(num, link.get(index));
	}
	

}
