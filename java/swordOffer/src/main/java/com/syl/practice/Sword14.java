package com.syl.practice;

import com.syl.tools.ListNode;

import java.util.List;

/**
 * 题目：两个的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Sword14 {

	/**
	 * 我的答案，暴力破解
	 * 但是感觉时间复杂度太大了，
	 * 调用了双重循环，假设两个链表的数目是a,b
	 * 那么时间复杂度就是O(a*b)了
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		while (pHead1 != null ){
			ListNode b = pHead2;
			while (b != null){
				if (pHead1.val == b.val){
					return pHead1;
				}
				b = b.next;
			}
			pHead1 = pHead1.next;
		}
		return null;
	}

	/**
	 * 其他方法
	 * 一个简单的方法是：首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，
	 * 以及长的链表比短的链表多几个节点。在第二次遍历的时候，先在较长的节点上走若干步，
	 * 接着同时在两个链表上遍历，
	 * 找到的第一个相同的节点就是它们的公共的节点。该算法的时间复杂度为：O(m+n)。
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		int a_len = nodeLength(pHead1);
		int b_len = nodeLength(pHead2);
		int step = a_len - b_len;
		if (step > 0){
			pHead1 = walkStep(pHead1,step);
		}else{
			pHead2 = walkStep(pHead2,-step);
		}
		while (pHead1 != null){
			if (pHead1.val == pHead2.val)
				return pHead1;
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
	}

	public ListNode walkStep(ListNode node,int step){
		while (step-- > 0){
			node = node.next;
		}
		return node;
	}

	public int nodeLength(ListNode node){
		int length = 0;
		while (node != null){
			length++;
			node = node.next;
		}
		return length;
	}
}
