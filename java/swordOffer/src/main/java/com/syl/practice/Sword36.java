package com.syl.practice;

import java.util.ArrayList;

/**
 * 题目：和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Sword36 {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 0) return list;
		for (int n = (int)Math.sqrt(sum*2);n>=2;n--) {
			if (sum*2%n==0 ){
				int d = 2*sum/n;
				if (((d^n)&1)!=0){
					int a1 = (d-n+1)/2;
					int an = (d+n-1)/2;
					ArrayList<Integer> temp = new ArrayList<>();
					for (int j = a1; j <= an ; j++) {
						temp.add(j);
					}
					list.add(temp);
				}
			}
		}

		return list;
	}
	
}
