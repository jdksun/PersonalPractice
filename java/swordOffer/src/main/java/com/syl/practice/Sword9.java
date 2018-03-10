package com.syl.practice;

/**
 * 题目：跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Sword9 {

	/**
	 * 我的答案
	 * 太耗费时间584ms
	 * @param target
	 * @return
	 */
	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2){
			return 2;
		}
		return JumpFloor(target-1) + JumpFloor(target - 2);
    }

	/***
	 * 我的答案
	 * 改进17ms
	 * @param target
	 * @return
	 */
    public int JumpFloor2(int target){
		int[] arry = new int[target+1];
		arry[0] = 1;
		arry[1] = 2;
		for (int i = 2;i < target;i++){
			arry[i] = arry[i-1] + arry[i-2];
		}
		return arry[--target];
	}

	/**
	 * 排名第一
	 * @param target
	 * @return
	 */
	public int JumpFloor3(int target) {
		if(target <= 0) return 0;
		if(target == 1) return 1;
		if(target == 2) return 2;
		int one = 1;
		int two = 2;
		int result = 0;
		for(int i = 2; i < target; i++){
			result = one+ two;
			one = two;
			two = result;
		}
		return result;
	}

	/**
	 * 排名第二
	 */
	public int JumpFloor4(int target) {
		if(target==-1)
			return 0;
		else if(target==1)
			return 1;
		else if(target==2)
			return 2;
		else
			return JumpFloor4(target-1) + JumpFloor4(target-2);

	}
}
