package com.syl.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Sword30 {

	/**
	 * 注意，remove方法有两个
	 * 一个是int类型，
	 * 一个是Object类型，
	 * 这里必须用将int类型变为引用类型，不然的话，会造成remove方法重载
	 * 导致是从数组下表删除，从而无法达到目的
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (list.contains(array[i])){
				list.remove(Integer.valueOf(array[i]));
			}else
				list.add(array[i]);
		}
		if (list.size()!=0){
			num1[0] = list.get(0);
			num2[0] = list.get(1);
		}
	}

	/**
	 * 位运算
	 //1. 除了有两个数字只出现了一次，其他数字都出现了两次。异或运算中，任何一个数字和自己本身异或都是0，任何一个数字和0异或都是本身。
	 //2. 如果尝试把原数组分成两个子数组，且刚好每个子数组中各自包含一个只出现一次的数字。则在该前提下，每个子数组中，只有一个数字出现了一次，其他数字都出现了两次。
	 //3. 针对每个子数组，从头到尾依次异或每个数字，则最后留下来的就是只出现了一次的数字。因为出现两次的都抵消掉了。
	 //4. 怎样实现子数组的划分呢。若对原数组从头到尾的进行异或，则最后得到的结果就是两个只出现一次的数字的异或运算结果。这个结果的二进制表示中，至少有一位为1，因为这两个数不相同。该位记为从最低位开始计数的第n位。
	 //5. 则分组的标准定为从最低位开始计数的第n位是否为1。因为出现两次的同一个数字，各个位数上都是相同的，所以一定被分到同一个子数组中，且每个子数组中只包含一个出现一次的数字。
	 * @param array
	 * @param num1
	 * @param num2
	 */
	public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
		int bitResult = 0;
		for (int i = 0; i < array.length; i++) {
			bitResult ^= array[i];
		}
		int index = findFirstOne(bitResult);
		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i],index)){
				num1[0]^=array[i];
			}else
				num2[0]^=array[i];
		}
		StringBuffer sb = new StringBuffer();
	}
	private int findFirstOne(int bitResult){
		int index = 0;
		while (((bitResult &1) == 0)&&index<32){
			bitResult>>=1;
			index++;
		}
		return index;
	}
	private boolean isBit(int target,int index){
		return ((target>>index) & 1) == 1;
	}
		public static void main(String[] args) {
		Sword30 s = new Sword30();
		int[] a = {2,4,3,6,3,2,5,5};
		int[] b = new int[1];
		int[] c = new int[1];
		s.FindNumsAppearOnce2(a,b,c);
		System.out.println(b[0]);
		System.out.println(c[0]);
	}
}
