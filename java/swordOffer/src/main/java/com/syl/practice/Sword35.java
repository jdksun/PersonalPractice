package com.syl.practice;

/**
 * 题目：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Sword35 {
	/**
	 *
	 有一个士兵和他自己打架就赢一分，和别人打架就输一分，他的分数是零就出局了。从下一个排号的开始（也可能是他自己）再进行以上，一直比到最后还有分的那个，
	 就可能是胜利者（如果这个胜利者是恰巧赢了那几局，就说明那个出现最多的那个士兵并不存在，所以最后重新计数）
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
		int len = array.length;
		if (len == 0) return len;
		int num = array[0];
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (array[i] == num){
				count++;
			}else {
				count--;
			}
			if (count == 0){
				num = array[i];
				count = 1;
			}
		}
		count = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] == num) count++;
		}

		return count > len/2 ? num : 0;
	}
	
}
