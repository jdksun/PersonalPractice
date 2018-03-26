package com.syl.practice;

/**
 * 题目：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 提示：查找排序
 */
public class Sword18 {

	/**
	 * 暴力破解，脑残，不过没有理解题意
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray(int [] array) {
		if (array.length == 0) return 0;
		int min = array[0];
		for (int i=0;i<array.length;i++){
			if (min > array[i]) min = array[i];
		}
		return min;
	}

	/**
	 * 二分法查找，不知道为什么 编译无法通过
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray2(int [] array) {
		if (array.length == 0) return 0;
		int left = 0;
		int right = array.length -1;
		int mid = (left + right)/2;
		if (array[left] == array[mid] || array[right] == array[mid] || array[left] == array[right] )
			return minInOrider(array);
		if (array[left] < array[mid] && array[right] > array[mid]) return array[0];
		while (true){
			if (right - left == 1){
				mid = right;
				break;
			}
			mid = (left + right)/2;
			//算上一种特殊情况,1,1,1,0,1
			if (array[mid] > array[left]){
				left = mid;
			}else if (array[mid] < array[right]){
				right = mid;
			}
		}
		return array[mid];
	}

	public int minInOrider(int[] arry){
		int min = arry[0];
		for (int i = 0;i<arry.length;i++){
			if (min > arry[i])
				min = arry[i];
		}
		return min;
	}

	/**
	 * 也是二分法
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray3(int[] array){
		int low = 0 ;
		int high = array.length - 1;
		while (low < high){
			int mid = (low + high)/2;
			if (array[mid] > array[high]){
				low = mid + 1;
			}else if (array[mid] == array[high]){
				high--;
			}else{
				high = mid;
			}
		}
		return array[low];
	}

	/**
	 * 冒泡
	 */
	public int minNumberInRotateArray4(int [] array) {
		if (array.length == 0)
			return 0;
		for (int i = 0; i < array.length - 1; i++)
			if (array[i] > array[i + 1])
				return array[i + 1];
		return array[0];
	}
}
