package com.syl.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目：连续子树组的最大和
 *  HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 *  他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 *  当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 *  并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 *  连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 *  解题思路：
 *  时间效率,动态规划
 */
public class Sword11{

	/**
	 * 我的答案
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array.length == 0) return  0;
		int res = array[0];
		int max = array[0];
		for(int i =1;i<array.length;i++){
			max = array[i] + max > array[i] ? array[i] + max : array[i];
			res = max > res ? max : res;
		}
		return res;
	}

	/**
	 * 排名第一
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray2(int[] array) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<array.length;i++){
			int sum = 0;
			for(int j=i;j<array.length;j++){
				sum += array[j];
				list.add(sum);
			}
		}
		if(list.size() <=0) return 0;
		Collections.sort(list);
		return list.get(list.size()-1);
	}


}
