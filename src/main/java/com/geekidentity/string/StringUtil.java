package com.geekidentity.string;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对String的一些操作。
 * @author geekidentity
 * @since 0.0.1
 * @version 0.0.1
 */
public class StringUtil {
	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	/**
	 * 判断str 是否纯数字
	 * @param str String
	 * @return 纯数字为true
	 */
	public static boolean isPureDigital(String str) {
		return str.matches("\\D+");
	}
	
	/**
	 * 修改String中的值，将target中的字符串copy到source中，复制内容取决length最短的那个。
	 * 该操作会改变source引用的值。
	 * @param source 要改变的String
	 * @param target 要复制的String
	 */
	public static void modifier(String source, String target) {
		try {
			Field valueField = String.class.getDeclaredField("value");
			valueField.setAccessible(true);
			char []ref = (char[]) valueField.get(source);
			char []targetCh = target.toCharArray();
			//取最短
			int  length = targetCh.length > source.length()? source.length():target.length();
			System.arraycopy(targetCh, 0, ref, 0, length);
		} catch (Exception e) {
			logger.error("String强行修改失败", e);
		}
	}
	
	public static int find(String str, String pat) {
		char ch[] = str.toCharArray();
		char p[] = pat.toCharArray();
		int j;
		for (int i = 0; i < ch.length-p.length; i++) {
			for (j = 0; j < p.length && ch[i+j]==p[j]; j++) {
			}
			if (j==(p.length)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 先检测末端标记的匹配方法
	 * @param str
	 * @param pat
	 * @return
	 */
	public static int nfind(String str, String pat) {
		char ch[] = str.toCharArray();
		char p[] = pat.toCharArray();
		int j = 0, start = 0, lasts = str.length() - 1, lastp = p.length - 1, endmath = lastp;
		for (int i = 0; endmath <= lasts; endmath++, start++) {
			if (ch[endmath] == p[lastp]) {
				for (j = 0,i = start; j < lastp && ch[i]==p[j]; i++, j++) {
				}
			}
			if (j == lastp) {
				return start;
			}
		}
		return -1;
	}
}
