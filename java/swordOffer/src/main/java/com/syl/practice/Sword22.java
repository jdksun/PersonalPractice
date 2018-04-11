package com.syl.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：孩子们的游戏(圆圈中最后剩下的数)
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,
 * 让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Sword22 {

	/**
	 * 用数组模拟环，但是这种方法比较耗时
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m<1)return -1;
		int[] a = new int[n];
		int step = 0;
		int count = n;
		int i = -1;
		while(count > 0){
			i++;
			if (i >= n) i = 0;
			if (a[i] == -1) continue;
			step++;
			if (step == m){
				a[i] = -1;
				step = 0;
				count--;
			}
		}
		return i;
	}

	/**
	 * 队列 理解起来so easy
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution2(int n, int m) {
		if (n < 1 ||m<1) return -1;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0;i<n;i++)
			queue.add(i);

		int step = 0;
		while (queue.size() >1){
			int temp = queue.poll();
			step++;
			if (step == m){
				step = 0;
			}else {
				queue.add(temp);
			}
		}
		return queue.peek();
	}

	/**
	 * 网上比较热门的递推
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution3(int n, int m) {
		if (n == 0) return -1;
		if (n == 1)
			return 0;
		else
			return (LastRemaining_Solution3(n-1,m)+m)%n;
	}
}
