package com.geekidentity.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author 侯法超
 * @date  2016年9月23日  下午9:58:16
 *
 */
public class ArrayListTest {
	private ArrayList<Integer> list;
	private Random random;
	
	@Before
	public void init() {
		list = new ArrayList<Integer>(10);
		Random random = new Random();
		System.out.print("add element to list:\t");
		int size = 5;
		for (int i = 0; i < size; i++) {
			int t = random.nextInt(100);
			list.add(t);
			System.out.print(t + "\t");
		}
		assertEquals(size, list.size());
	}
	
	@Test
	public void add() {
		int size = list.size();
		Integer t = new Random().nextInt(100);
		list.add(size, t);
		assertEquals(t, list.get(size));
		assertEquals(size+1, list.size());
	}
	
	@Test
	public void remove() {
		int size = list.size();
		list.remove(new Random().nextInt(size));
		assertEquals(size-1, list.size());
	}
	
	@Test
	public void set() {
		int size = list.size();
		random = new Random();
		int index = random.nextInt(size);
		Integer element = random.nextInt(100);
		list.set(index, element);
		assertEquals(element, list.get(index));
	}

}
