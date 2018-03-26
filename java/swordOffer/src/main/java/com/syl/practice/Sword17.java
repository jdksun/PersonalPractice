package com.syl.practice;

/**
 * 题目：字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 提示：字符串
 */
public class Sword17 {
	/**
	 * char字符一个字符占8位，所以可以构造一个简单的256位hash算法
	 */
	private StringBuffer sb = new StringBuffer();
	private int[] hashtable = new int[128];
	//Insert one char from stringstream
	public void Insert(char ch)
	{
		sb.append(ch);
		if (hashtable[ch] == 0) hashtable[ch] = 1;
		else hashtable[ch] += 1;
	}
	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce()
	{
		char[] array = sb.toString().toCharArray();
		for (char x : array){
			if (hashtable[x] == 1)
				return x;
		}
		return '#';
	}
	
}
