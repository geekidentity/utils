package com.geekidentity.string.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thinking In Java Page 335
 * @Project: Utils
 * @Package: com.geekidentity.string.reg
 * @author: 侯法超
 * @date: 2016年10月2日  下午8:26:47
 * @version: V1.0
 *
 */
public class Groups {
	private static final String POEM = 
			"Twas brilling, and the slithy toves\n"
			+ "Did gyre and gimble in the wabe.\n"
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwork, my son.\n"
			+ "The jaws that bite. the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n"
			+ "The frumious Bandersnatch.";
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while (m.find()) {
			for (int i = 0; i < m.groupCount(); i++) {
				System.out.print("[" + m.group(i) + "]");
			}
			System.out.println();
		}
	}
}
