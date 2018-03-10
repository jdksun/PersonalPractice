package com.syl.practice;

/**
 * 题目：变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * *****************************
 * 解题要点
 * 找规律
 */
public class Sword4 {
	/**
	 * 我的答案
	 * 递归
	 * @param target
	 * @return
	 */
	public int JumpFloorII(int target) {
		if (target == 1 || target == 0) {
			return 1;
		}else{
			return 2*JumpFloorII(target - 1);
		}
	}

	/**
	 * 排名第一答案
	 * @param target
	 * @return
	 */
	public int JumpFloorII2(int target) {
		if(target == 0) {
			return 0;
		}

		int[] dp = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2;i <= target;i++) {
			dp[i] = 0;
			for(int j = 0;j < i;j++) {
				dp[i] += dp[j];
			}
		}

		return dp[target];
	}

	/**
	 * 排名第二答案
	 * @param target
	 * @return
	 */
	public int JumpFloorII3(int target) {
		return 1<<--target;
	}
}
