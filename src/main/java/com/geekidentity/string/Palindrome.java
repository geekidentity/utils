package com.geekidentity.string;


/**
 * 最长回文子串
 * @author 侯法超
 * @date  2016年9月5日  下午7:04:00
 *
 */
public class Palindrome {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String str = "Confuciuss say: Madam, I`m Adam.";
		String s1 = "abaa478905478901534789012347890123874123908472901471234890478123047128904712489021748912304712389042741239047129481275490478123438901247123947824890237234012547853478123489123874789483848438741230412378491238941234712389437891248123471248901247812789046785346782347854367853467851234678951347891234678123489041478938741278947123409123478547801284712389041237843890124712389043278431289048712908347123490237490";
		String s2 = "abba";
		System.out.println(v2(s1));
	}
	
	/**
	 * 最基本的，用循环做
	 */
	public static int v1(String str) {
		int max = 0;
		int begin = 0, end = 0;
		char []s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			for (int j = i; j < s.length; j++) {
				boolean ok = true;
				for (int k = i; k<=j; k++) {
					if (s[k]!=s[j+i-k]) {
						ok = false;
					}
				}
				if (ok && max<j-i+1) {
					max = j-i+1;
					begin = i;
					end = j;
				}
			}
		}
		for (int i = begin; i <= end; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
		return max;
	}
	
	/**
	 * 枚举回文串的中间位置i，然后不断向外扩展，直到有字符串不同。
	 * 注：奇偶要分开
	 * @param str
	 * @return
	 */
	public static int v2(String str) {
		int max = 0;
		int begin = 0, end = 0;
		char []s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; i-j>=0&& i+j<s.length; j++) {
				if (s[i-j]!=s[i+j]) {
					break;
				}
				if (max < 2*j+1) {
					max = 2*j+1;
					begin = i-j;
					end = i+j;
				}
			}
			for (int j = 0; i-j>=0 && i+j+1<s.length; j++) {
				if (s[i-j]!=s[i+j+1]) {
					break;
				}
				if (max < j*2+2) {
					max = j*2+2;
					begin = i-j;
					end = i+j+1;
				}
			}
		}
		for (int i = begin; i <= end; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
		return max;
	}
}
