package com.geekidentity.math;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class MathsTest {

	@Test
	public void getGCDTest() {
		assertEquals(4, Maths.getGCD(12, 16));
		assertEquals(1, Maths.getGCD(10001, 10000));
	}
	
	@Test
	@Ignore
	public void bigRandomTest() {
		for (int i = 0; i < 100000; i++) {
			double result = Maths.bigRandom();
			System.out.println(String.valueOf(result));
		}
	}

	@Test
	public void randomTest() {
		for (int i = 0; i < 500; i++) {
			System.out.println(Maths.random(10, 20));
		}
	}
}
