package com.syl.practice;

/**
 * 题目：矩阵覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * *****************************
 * 解题思路
 * 递归循环
 * 依然是斐波那契数列
 *     	******* 分析 *******
 * 当n<=0, return 0;
 * 当n=1, return 1;
 * 当n=2, return 2;
 * 当n=3, 分两种情况，在n=1基础上另外一部分为n=2
 *
 如果我们现在归纳 n = 4，应该是什么形式？
 4.1）保持原来n = 3时内容，并扩展一个 2*1 方块，形式分别为 “| | | |”、“= | |”、“| = |”
 4.2）新增加的2*1 方块与临近的2*1方块组成 2*2结构，然后可以变形成 “=”。于是 n = 4在原来n = 3基础上增加了"| | ="、“= =”。
 再自己看看这多出来的两种形式，是不是只比n = 2多了“=”。其实这就是关键点所在...因为，只要2*1或1*2有相同的两个时，就会组成2*2形式，于是就又可以变形了。
 所以，自然而然可以得出规律： f(n) = f(n-1) + f(n-2)， (n > 2)。
 *
 */
public class Sword10 {

	/**
	 * 我的答案
	 * @param target
	 * @return
	 */
	public int RectCover(int target) {
		if (target <= 0) return 0;
		if (target == 1) return 1;
		if (target == 2) return 2;
		int one = 1;
		int two = 2;
		int result = 0;
		for (int i=2;i<target;i++){
			result = one + two;
			one = two;
			two = result;
		}
		return result;
	}
}
