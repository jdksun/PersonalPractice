package com.syl.practice;

import com.syl.tools.ListNode;

/**
 * 题目：合并两个排序链表
 *
 */
public class Sword33 {

	public ListNode Merge(ListNode list1,ListNode list2){
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		ListNode head = null;
		ListNode current = null;
		while (list1!=null&&list2!=null){
			if (list1.val < list2.val){
				if (head == null){
					head = current = list1;
				}else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			}else {
				if (head == null){
					head = current =list2;
				}else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 != null){
			current.next = list1;
		}
		if (list2 != null){
			current.next = list2;
		}
		return head;
	}
	public ListNode Merge2(ListNode list1,ListNode list2){
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		if (list1.val < list2.val){
			list1.next = Merge(list1.next,list2);
			return list1;
		}else {
			list2.next = Merge(list1,list2.next);
			return list2;
		}
	}
}
