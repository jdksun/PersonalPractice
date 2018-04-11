package com.syl.practice;

/**
 * 题目:数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class Sword25 {

	/**
	 * 二分法
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
		if (array.length == 0) return 0;
		return getIndex(array,k,0,array.length-1);
	}


	private int getIndex(int[] array,int k,int start,int end){
		if (start > end) return 0;
		int mid = (start + end)/2;
		if (array[mid] > k){
			return getIndex(array,k,start,mid-1);
		}else if (array[mid] <k){
			return getIndex(array,k,mid+1,end);
		}else
			return 1+getIndex(array,k,start,mid-1) + getIndex(array,k,mid+1,end);
	}

	/**
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK2(int [] array , int k) {
		if (array.length == 0) return 0;
		int left = getFirst(array,k,0,array.length-1);
		int right = getLast(array,k,0,array.length-1);
		if (left != -1 && right != -1){
			return right-left+1;
		}
		return 0;
	}

	/**
	 * 循环写法
	 * @param array
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	private int getFirst(int[] array,int k,int start,int end){
		while (start<=end){
			int mid = (start+end) /2;
			if (array[mid] > k){
				end = mid-1;
			}else if (array[mid] <k){
				start = mid +1;
			}else{
				if ((mid > 0 &&array[mid-1]!=k)||mid == 0){
					return mid;
				}else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 递归写法
	 * @param array
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	private int getLast(int[] array,int k,int start,int end){
		if (start > end) return -1;
		int mid = (start+end)/2;
		if (array[mid]>k)
			return getLast(array,k,start,mid-1);
		else if (array[mid] < k)
			return getLast(array,k,mid+1,end);
		else if (mid+1<array.length&&array[mid+1]==k){
			return getLast(array,k,mid+1,end);
		}else
			return mid;
	}
}
