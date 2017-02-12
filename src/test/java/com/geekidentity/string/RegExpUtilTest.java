package com.geekidentity.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegExpUtilTest {

	@Test
	public void isPositiveIntegerTest() {
		int n1 = +223;
		assertEquals(true, RegExpUtil.isPositiveInteger(n1));
		int n2 = -1;
		assertEquals(false, RegExpUtil.isPositiveInteger(n2));
	}
	
	@Test
	public void isIntegerTest() {
		int n1 = +234;
		assertEquals(true, RegExpUtil.isInteger(n1));
		int n2 = -1;
		assertEquals(true, RegExpUtil.isInteger(n2));
	}

}
