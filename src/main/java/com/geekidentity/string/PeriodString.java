package com.geekidentity.string;

/**
 * 判断一个字符串是否是周期串
 * @author 侯法超
 * @date  2016年9月7日  下午6:26:26
 *
 */
public class PeriodString {
	public static void main(String[] args) {
		String str = "abcabcabcabc";
		System.out.println(period(str));
	}
	
	public static int period(String str) {
		int period = 0;
		char []s = str.toCharArray();
		for (int i = 1; i <= s.length; i++) {
			boolean ok = true;
			for (int j = i; j < s.length; j++) {
				if (s[j]!=s[j%i]) {
					ok = false;
					break;
				}
			}
			if (ok) {
				period = i;
				break;
			}
		}
		return period;
	}
}
