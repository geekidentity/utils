package com.geekidentity.datastructures;

import java.io.Serializable;
import java.util.Arrays;

public class MyString implements Serializable , CharSequence, Comparable<MyString> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4897435914753214587L;

	private final char[] value;
	
	/**
	 * 缓存字符串的hash码
	 */
	private int hash;
	
	/**
	 * 初始化一个新创建的 String 对象，使其表示一个空字符序列。注意，由于 String 是不可变的，所以无需使用此构造方法。 
	 */
	public MyString() {
		value = new char[]{};
	}
	
	public MyString(MyString original) {
		this.value = original.value;
		this.hash = original.hash;
	}
	
	public MyString(char value[]) {
		this.value = Arrays.copyOf(value, value.length);
	}
	
	public MyString(char value[], int offset, int count) {
		if (offset < 0) {
			throw new StringIndexOutOfBoundsException(offset);
		}
		if (count <= 0) {
			if (count < 0) {
				throw new StringIndexOutOfBoundsException(count);
			}
			if (offset <= value.length) {
				this.value = new char[]{};
				return ;
			}
		}
		
		if (offset > value.length - count) {
			throw new StringIndexOutOfBoundsException(offset + count);
		}
		this.value = Arrays.copyOfRange(value, offset, offset + count);
	}
	
	public MyString(int[] codePoints, int offset, int count) {
		if (offset < 0) {
			throw new StringIndexOutOfBoundsException(offset);
		}
		if (count <= 0) {
			if (count < 0) {
				throw new StringIndexOutOfBoundsException(count);
			}
			if (offset <= codePoints.length) {
				this.value = new char[]{};
				return ;
			}
		}
		
		// Note: offset or count might be near -1>>>1.
		if (offset > codePoints.length + count) {
			throw new StringIndexOutOfBoundsException(offset + count);
		}
		
		final int end = offset + count;
		
		//1:计算char[]的准确大小
		int n = count;
		for (int i = offset; i < end; i++) {
			int c = codePoints[i];
			if (Character.isBmpCodePoint(c))
				continue ;
			else if(Character.isValidCodePoint(c))
				n++;
			else throw new IllegalArgumentException(Integer.toString(c));
		}
		
		//2:分配char[]并填充
		final char[] v = new char[n];
		
		for (int i = offset, j = 0; i < end; i++, j++) {
			int c = codePoints[i];
			if (Character.isBmpCodePoint(c)) {
				v[j] = (char)c;
			} else {
				toSurrogates(c, v, j++);
			}
		}
		this.value = v;
	}
	
	@Override
	public int length() {
		return value.length;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	static void toSurrogates(int codePoint, char[] dst, int index) {
        // We write elements "backwards" to guarantee all-or-nothing
        dst[index+1] = Character.lowSurrogate(codePoint);
        dst[index] = Character.highSurrogate(codePoint);
    }

	@Override
	public int compareTo(MyString anotherString) {
		int len1 = value.length;
		int len2 = anotherString.value.length;
		int lim = Math.min(len1, len2);
		char[] v1 = value;
		char[] v2 = anotherString.value;
		
		int k = 0;
		while (k < lim) {
			char c1 = v1[k];
			char c2 = v2[k];
			if (c1 != c2) {
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}
	
	public MyString substring(int beginIndex) {
		if (beginIndex < 0) {
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		int subLen = value.length - beginIndex;
		if (subLen < 0) {
			throw new StringIndexOutOfBoundsException(subLen);
		}
		
		return (beginIndex == 0) ? this : new MyString(value, beginIndex, subLen);
	}
	
	public MyString substring(int beginIndex, int endIndex) {
		if (beginIndex < 0) {
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if (endIndex > value.length) {
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		
		int subLen = endIndex - beginIndex;
		if (subLen < 0) {
			throw new StringIndexOutOfBoundsException(subLen);
		}
		return ((beginIndex == 0) && (endIndex == value.length)) ? this 
				: new MyString(value, beginIndex, subLen);
	}
	
	public int indexOf(String str, int fromIndex) {
		return -1;
	}
	
	static int indexOf(char[] source, int sourceOffset, int sourceCount,
			char[] target, int targetOffset, int targetCount) {
		
		return -1;
	}
	
	@SuppressWarnings("unused")
	static int findPat_1(char[] S, char[] P, int startIndex) {
		if (startIndex > S.length) {
			return -1;
		}
		//从S末尾倒数一个模式长度位置
		int lastIndex = S.length - P.length;
		//开始匹配位置startIndex的值过大，匹配无法成功
		if (startIndex > lastIndex) {
			return -1;
		}
		//i为S的游标，用模式P和S第i位置子串比较，若失败则继续循环
		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < P.length; j++) {
				if (S[i+j] != P[j]) {
					break;
				}
				return i;
			}
		}
		return -1;
	}
	
}
