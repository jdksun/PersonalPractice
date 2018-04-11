package com.syl.practice;

/**
 * 题目：斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class Sword28 {

	/**
	 * 太浪费空间
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
		if (n == 0) return 0;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0||i ==1){
				a[i] = 1;
			}else {
				a[i] = a[i-1]+a[i-2];
			}
		}
		return a[n-1];
	}

	/**
	 * 如此聪明的一种算法，
	 * pre = f(n);
	 * next = f(n+1);
	 * 	next += pre;　代表f(n+2) = f(n+1)+f(n);
	 *	pre = next - pre; 代表　f(n+1)=f(n+2)-f(n);
	 * @param n
	 * @return
	 */
	public int Fibonacci2(int n) {
		int pre = 0;
		int next = 1;
		while (n-- > 0){
			next += pre;
			pre = next - pre;
		}
		return pre;
	}
}
