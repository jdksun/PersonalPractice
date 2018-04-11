package com.syl.practice;

import com.syl.tools.ListNode;

import java.util.*;

/**
 * 题目：反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Sword27 {

	public ListNode ReverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head!=null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}


//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int work = s.nextInt();
//		int person = s.nextInt();
//
//		Map<Integer,Integer> map = new HashMap<>();
//		int[] z = new int[work+person];
//		int[] y = new int[person];
//		for (int i=0;i<work;i++){
//			int a = s.nextInt();
//			int b = s.nextInt();
//			z[i] = a;
//			map.put(a,b);
//		}
//		for (int i=0;i<person;i++){
//			int a = s.nextInt();
//			y[i] = a;
//			z[work+i] = a;
//			if (!map.containsKey(a)){
//				map.put(a,0);
//			}
//		}
//		Arrays.sort(z);
//		int m = 0;
//		for (int i=0;i<work+person;i++){
//			m = Math.max(m,map.get(z[i]));
//			map.put(z[i],m);
//		}
//		for (int i=0;i<person;i++){
//			System.out.println(map.get(y[i]));
//		}
//
//	}



	
}
