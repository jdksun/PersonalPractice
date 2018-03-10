package com.syl.practice;

/**
 * 题目 ：构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Sword5 {
	/**
	 * 我的答案
	 * @param A
	 * @return
	 */
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		int ret = 1;
		for(int i = 0 ;i < A.length;ret*=A[i++]) {
			B[i] = ret;
		}
		ret = 1;
		for(int i = A.length - 1 ;i >= 0;ret *= A[i--]) {
			B[i] *= ret;
		}
		return B;
	}

	/**
	 * 排名第一答案
	 * @param A
	 * @return
	 */
	public int[] multiply2(int[] A) {
		if (A.length<=0){
			return A;
		}
		int sum = 1;
		for (int i = 0;i<A.length;i++){
			sum *=A[i];
		}
		if (sum==0){
			sum=1;
			int flag = 0;
			int num = 0;
			for (int i = 0;i<A.length;i++){
				if (!(A[i]==0)&&flag<2){
					sum *=A[i];
				}else if (A[i]==0&&flag<2){
					num = i;
					flag++;
				}else {
					break;
				}
			}
			for (int i = 0;i<A.length;i++){
				A[i]=0;
			}
			if (flag<2){
				A[num]=sum;}
			return A;
		}
		int[] B = A;
		for (int i =0;i<A.length;i++){
			B[i] = (int) (sum * Math.pow(A[i],-1));
		}
		return B;
	}

	/**
	 * 排名第二答案
	 * @param A
	 * @return
	 */
	public int[] multiply3(int[] A) {
		if (A == null || A.length == 0) {
			return new int[1];
		}
		int[] B = new int[A.length];
		int tmp1 = 1;
		int[] tmp2 = new int[A.length];
		tmp2[A.length - 1] = 1;
		for (int i = 1; i < A.length; i++) {
			tmp2[A.length - i - 1] = tmp2[A.length - i] * A[A.length - i];
		}
		for (int i = 0; i < A.length; i++) {
			if(i!=0){
				tmp1 *=A[i-1];
			}
			B[i] = tmp1 * tmp2[i];
		}
		return B;
	}
}
