package com.geekidentity.mail;

/**
 * 对邮件地址进行封装，方便使用。
 * 
 * @author geekidentity
 * @since 0.0.1
 * @version 0.0.1
 */
public class MailAddress {
	private String mailAddress;

	public MailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * 获取邮箱前缀
	 * @return 邮箱前缀
	 */
	public String getPrefix() {
		return mailAddress.substring(0, mailAddress.indexOf('@'));
	}
	
	/**
	 * 获取邮箱后缀
	 * @return 邮箱后缀
	 */
	public String getSuffix() {
		return mailAddress.substring(mailAddress.indexOf('@'), mailAddress.length());
	}
	
	/**
	 * 获取邮箱域名
	 * @return 邮箱域名
	 */
	public String getDomainName() {
		return mailAddress.substring(mailAddress.indexOf('@') + 1, mailAddress.length());
	}
}
