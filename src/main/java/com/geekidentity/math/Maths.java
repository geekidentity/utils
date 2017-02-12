package com.geekidentity.math;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class Maths {
	
	private static final double RAND_MAX = 123456789012345678901234567890F;
	
	/**
	 * 获取两个数的最大公约数 GCD(Greatest Common Divisor)<br>
	 * 更相减损术避免了取模运算，但是算法性能不稳定，最坏时间复杂度为O(max(a, b)))，
	 * 更相减损术与移位结合，不但避免了取模运算，而且算法性能稳定，时间复杂度为O(log(max(a, b)))。
	 * <br>
	 * <strong>算法思路：</strong>
	 * <br>
	 * 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)<br>
	 * 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)<br>
	 * 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)<br>
	 * 当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
	 * <br>
	 * <strong>说明：</strong>
	 * 在九章算术原文中多了一步验证：如果两数都是偶数，计算差值之前会首先让两个数都折半，使得计算次数更少。
	 * 这种方法做到了部分优化，但古人似乎没想到一奇一偶的情况也是可以优化的。
	 * @param a
	 * @param b
	 * @return 两个数的最大公约数
	 */
	public static int getGCD(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a < b) {
			//保参数a永远大于参数b，为减少代码量。
			return getGCD(b, a);
		} else {
			//和1做按位与运算，判断奇偶性
			if ((a&1)==0 && (b&1) == 0) {
				return getGCD(a >> 1, b >> 1) << 1;
			} else if ((a&1)==0 && (b&1) == 1) {
				return getGCD(a >> 1, b);
			} else if ((a&1)==1 && (b&1) == 0) {
				return getGCD(a, b >> 1);
			} else {
				return getGCD(b, a - b);
			}
		}
	}
	
	/**
	 * 生成超大随机数，至少30位大随机数。
	 * @return 至少30位大随机数
	 */
	public static double bigRandom() {
		Random random = new Random();
		random.nextInt(Integer.MAX_VALUE);
		return RAND_MAX * random.nextInt(Integer.MAX_VALUE) + random.nextInt(Integer.MAX_VALUE);
	}
	
	/**
	 * 生成指定范围内随机数，包括上下限。
	 * @param low 下限
	 * @param high 上限
	 * @return 指定范围内随机数
	 */
	public static double random(int low, int high) {
		Random random = new Random();
		return low + random.nextInt(high) % (high - low + 1);
	}
	
	/**
	 * 仅用O(1)的空间，将整数数组按奇偶数分成2部分，数组左边是奇数、右边是偶数。<br>
	 * 用两个指针，一个指向左边的偶数，一个指向右边的奇数，然后交换两个数，移动两个指针，继续上面操作
	 * @param array 要处理的数组
	 */
	public static void swap(int[] array) {
		int left = 0, right = array.length - 1;
		while (left < right) {
			
		}
	}
	
	/**
	 * 求一组数的均值
	 * @param list
	 * @return
	 */
	public static Number mean(List<Number> list) {
		BigDecimal sum = new BigDecimal(0);
		for (Number num : list) {
			sum.add(new BigDecimal(num.doubleValue()));
		}
		return sum.divide(new BigDecimal(list.size()));
	}
	
	/**
	 * 求中位数
	 * @param list
	 * @return
	 */
	public static Number median(List<Number> list) {
		if (list.size() == 0) {
			throw new IllegalArgumentException("数组不应该为空");
		}
		if (list.size() == 1) {
			return list.get(0);
		}
		if (list.size()%2 == 1) {//奇数个
			return list.get(list.size()/2);
		} else {//偶数个
			double a = list.get(list.size()/2).doubleValue();
			double b = list.get(list.size()/2-1).doubleValue();
			return (a+b)/2;
		}
	}
	
	/**
	 * 求众数
	 * @param list
	 * @return
	 */
	public static Number mode(List<Number> list) {
		return null;
	}
}
