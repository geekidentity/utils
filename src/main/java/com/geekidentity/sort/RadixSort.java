package com.geekidentity.sort;

/**
 * 基数排序
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年11月7日  下午10:15:55
 * @version: V1.0
 *
 */
public class RadixSort {
	/**
	 * 
	 * @param array
	 * @param d 桶排序次数
	 * @param r 计数器个数
	 */
	public static void sort(Integer[] array, int d, int r) {
		Integer[] tempArray = new Integer[array.length];
		int[] count = new int[r];
		int radix = 1;//模进位，用于取array[i]的第i位
		for (int i = 1; i <= d; i++) {//对第i个排序码进行分配
			for (int j = 0; j < r; j++) {//初始计数器均为零
				count[j] = 0;
			}
			for (int j = 0; j < array.length; j++) {//统计每桶记录数
				int k = (array[j]/radix)%r;//取第i位
				count[k] ++;//相应计数器加1
			}
			for (int j = 1; j < r; j++) {//给桶划分下标界
				count[j] = count[j - 1] + count[i];
			}
			for (int j = array.length - 1; j >= 0; j--) {//从右往左收集
				int k = (array[j]/radix)%r;//取第i位
				count[k]--;//桶剩余量计数器减1
				tempArray[count[k]] = array[j];//入桶
			}
			System.arraycopy(tempArray, 0, array, 0, tempArray.length);//内容复制回array中
			radix *= r;
		}
	}
}
