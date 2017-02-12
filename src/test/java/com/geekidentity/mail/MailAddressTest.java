package com.geekidentity.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * MailAddress测试
 * @author geekidentity
 * @since 0.0.1
 * @version 0.0.1
 */
public class MailAddressTest {
	private MailAddress mailAddress;
	private String address;
	
	@Before
	public void init() {
		address = "geekidentity@163.com";
		mailAddress = new MailAddress(address);
	}
	
	@Test
	public void getPrefixTest() {
		assertEquals("geekidentity", mailAddress.getPrefix());
		assertEquals("@163.com", mailAddress.getSuffix());
		assertEquals("163.com", mailAddress.getDomainName());
	}
	
}
