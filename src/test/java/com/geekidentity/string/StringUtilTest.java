package com.geekidentity.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {
	
	private String str = "testStr";
	
	@Test
	public void isPureDigitalTest() {
		str = "23324";
		assertTrue(StringUtil.isPureDigital(str));
		assertFalse(StringUtil.isPureDigital("ddf23"));
	}
	
	@Test
	public void modifierTest() {
		str = "hello";
		StringUtil.modifier(str, "geek");
		assertEquals("geeko", str);
	}

	@Test
	public void findTest() {
		str = "ababbaabaa";
		String pat = "aab";
		int r = StringUtil.find(str, pat);
		assertEquals(5, r);
	}
	
	@Test
	public void nfindTest() {
		str = "ababbaabaa";
		String pat = "aab";
		int r = StringUtil.nfind(str, pat);
		assertEquals(5, r);
	}

}
