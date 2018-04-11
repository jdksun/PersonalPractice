package com.syl.practice;

/**
 * 题目：数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Sword31 {


	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if (length == 0) {
			duplication[0] = -1;
			return false;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(numbers[i]);
		}
		for (int i = 0; i < length; i++) {
			if (sb.indexOf(String.valueOf(numbers[i])) != sb.lastIndexOf(String.valueOf(numbers[i]))){
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}
	public boolean duplicate2(int numbers[],int length,int [] duplication) {
		if (length == 0){
			duplication[0] = -1;
			return false;
		}
		int[] hash = new int[length];
		for (int i = 0; i < length; i++) {
			if (hash[numbers[i]] == 1){
				duplication[0] = numbers[i];
				return true;
			}
			hash[numbers[i]]++;
		}
		return false;
	}
	public boolean duplicate3(int numbers[],int length,int [] duplication) {
		if (length == 0){
			duplication[0] = -1;
			return false;
		}
		for (int i = 0; i < length; i++) {
			while (i != numbers[i]){
				if (numbers[i] == numbers[numbers[i]]){
					duplication[0] = numbers[0];
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[numbers[i]];
				numbers[temp] = temp;
			}
		}
		return false;
	}
}
