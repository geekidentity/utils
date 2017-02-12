package com.geekidentity.sort;

/**
 * <h2>快速排序</h2>
 * 一次分割过程：<br>
 * 1：选择轴值并存储轴值<br>
 * 2：最后一个元素放到轴值位置<br>
 * 3：初始化下标i,j，分别指向头尾<br>
 * 4：i递增直到遇到比轴值大的元素，将此元素覆盖到j的位置；j递减直到遇到比轴值小的元素，将此元素覆盖到i的位置<br>
 * 5：重复上一步直到i==j，将轴值放到i的位置，完毕
 * 
 * @Project: Utils
 * @Package: com.geekidentity.sort
 * @author: 侯法超
 * @date: 2016年10月28日  上午10:02:25
 * @version: V1.0
 *
 */
public class QuickSort {
	
	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void sort(Integer[] array, int left, int right) {
		if (right <= left) {//只有0或1个记录，就不需要排序
			return ;
		}
		int pivot = selectPivot(left, right);//选择轴值
		swap(array, pivot, right);//轴值放到数组末尾，即最右边
		pivot = partition(array, left, right);//分割后轴值正确
		sort(array, left, pivot-1);//左子序列递归快排
		sort(array, pivot+1, right);//右子序列递归快排
	}
	
	private static void swap(Integer[] array, int pivot, int right) {
		int temp = array[pivot];
		array[pivot] = array[right];
		array[right] = temp;
	}

	/**
	 * 选择轴值
	 * @param left
	 * @param right
	 * @return
	 */
	private static int selectPivot(Integer left, int right) {
		return (left + right)/2;
	}

	/**
	 * 分割函数，分割后轴值已到达正确位置
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(Integer[] array, int left, int right) {
		int l = left;//左指针
		int r = right;//右指针
		int temp = array[r];//保存轴值
		while (l != r) {//l、r不断向中间移动，直到相遇
			//l指针向右移动，直到找到一个大于轴值的记录
			while (array[l] <= temp && l < r) {
				l++;
			}
			if (l < r) {//未相遇，将逆置元素换到右边空位
				array[r] = array[l];
				r--;//指针向左移一位
			}
			
			//指针向左移动，直到找到一个大于轴值的记录
			while (array[r] >= temp && l <r) {
				r--;
			}
			if (l < r) {
				array[l] = array[r];
				l++;
			}
		}
		array[l] = temp;//把轴值回填到分界位置l上
		return l;//返回分界位置
	}
}
