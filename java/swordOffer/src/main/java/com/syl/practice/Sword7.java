package com.syl.practice;

/**
 * 题目：求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sword7 {
	/**
	 * 我的答案
	 * @param n
	 * @return
	 */
	public int Sum_Solution(int n) {
		int sum = n;
		int temp = (int)Math.pow(n, 2);
		while(temp != 0) {
			int a = (sum & temp) << 1;
			sum = sum ^ temp;
			temp = a;
		}
		return sum>>1;
	}

	/**
	 * 排名第一答案
	 * @param n
	 * @return
	 */
	public int Sum_Solution2(int n) {
		int sum = (int) (Math.pow(n,2) + n);
		return sum>>1;
	}

	/**
	 * 排名第二答案
	 *短路求值
	 *作为"&&"和"||"操作符的操作数表达式，这些表达式在进行求值时，只要最终的结果已经可以确定是真或假，求值过程便告终止，
	 *这称之为短路求值（short-circuit evaluation）。这是这两个操作符的一个重要属性。
	 * @param n
	 * @return
	 */
	public int Sum_Solution3(int n) {
		int res = n;
		boolean flag = (n>0)&&((res+=Sum_Solution3(n-1))>0);
		return res;
	}
}
