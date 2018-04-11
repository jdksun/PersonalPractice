package com.syl.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目:左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 * 详解：https://blog.csdn.net/zhoushuai520/article/details/7703368
 */
public class Sword23 {

	/**
	 * 我的方法，利用了队列先进先出的特性
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString(String str,int n) {
		if (str.length() == 0 || n == 0) return str;
		Queue<Character> queue = new LinkedList<>();
		char[] c = str.toCharArray();
		for (int i=0;i<c.length;i++)
			queue.add(c[i]);
		while (n-- > 0){
			queue.add(queue.poll());
		}
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()){
			sb.append(queue.poll());
		}
		return sb.toString();
	}

	/**比较巧妙的一种方法，将整个字符串分成两部分，在线性时间内就可以完成
	 * 假设原数组序列为abcd1234，要求变换成的数组序列为1234abcd，即循环右移了4位。比较之后，不难看出，其中有两段的顺序是不变的：1234和abcd，可把这两段看成两个整体。右移K位的过程就是把数组的两部分交换一下。
	 变换的过程通过以下步骤完成：
	 逆序排列abcd：abcd1234 → dcba1234；
	 逆序排列1234：dcba1234 → dcba4321；
	 全部逆序：dcba4321 → 1234abcd。
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString2(String str,int n) {
		char[] c = str.toCharArray();
		int len = c.length;
		if (len == 0 || n == 0) return str;
		n = n % len;
		reverse(c,0,n-1);
		reverse(c,n,len-1);
		reverse(c,0,len-1);
		return new String(c);
	}
	private void reverse(char[] c,int low,int high){
		char temp;
		while (low < high){
			temp = c[low];
			c[low] = c[high];
			c[high] = temp;
			low++;
			high--;
		}
	}

	/**
	 * 方法二等同于
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString3(String str,int n) {
		if (str.length() == 0 || n == 0) return str;
		String a = str.substring(0,n);
		String b = str.substring(n,str.length());
		return b+a;
	}
}
