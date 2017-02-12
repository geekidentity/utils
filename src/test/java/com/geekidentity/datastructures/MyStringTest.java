package com.geekidentity.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyStringTest {
	
	@Before
	public void init() {
	}
	
	@Test
	public void test() {
	}
	
	@Test
	public void indexOf() {
		char[] S = {'h','e','l','l','o'};
		char[] P = {'l','l'};
		assertEquals(2, MyString.findPat_1(S, P, 0));
	}

}
