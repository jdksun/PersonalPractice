package com.syl.practice;

import com.syl.tools.ListNode;

/**
 * 题目：链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Sword21 {
	/**
	 *
	 假设x为环前面的路程（黑色路程），a为环入口到相遇点的路程（蓝色路程，假设顺时针走）， c为环的长度（蓝色+橙色路程）
	 当快慢指针相遇的时候：

	 此时慢指针走的路程为Sslow = x + m * c + a
	 快指针走的路程为Sfast = x + n * c + a
	 2 Sslow = Sfast
	 2 * ( x + m*c + a ) = (x + n *c + a)
	 从而可以推导出：
	 x = (n - 2 * m )*c - a
	 = (n - 2 *m -1 )*c + c - a
	 即环前面的路程 = 数个环的长度（为可能为0） + c - a
	 什么是c - a？这是相遇点后，环后面部分的路程。（橙色路程）
	 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
	 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
	 从相遇点开始走的那个指针也一定刚好到达环入口点。
	 所以2者会相遇，且恰好相遇在环的入口点。
	 最后，判断是否有环，且找环的算法复杂度为：
	 时间复杂度：O(n)
	 空间复杂度：O(1)
	 * @param pHead
	 * @return
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead)
	{
		if(pHead == null || pHead.next == null || pHead.next.next == null) return null;
		ListNode slow = pHead.next;
		ListNode fast = slow.next;
		while (slow != fast){
			if (fast.next !=null && fast.next.next != null){
				fast = fast.next.next;
				slow = slow.next;
			}else{
				return null;
			}
		}
		fast = pHead;
		while (fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 两个指针，一个在前面，另一个紧邻着这个指针，在后面。
	 两个指针同时向前移动，每移动一次，前面的指针的next指向NULL。
	 也就是说：访问过的节点都断开，最后到达的那个节点一定是尾节点的下一个，
	 也就是循环的第一个。
	 这时候已经是第二次访问循环的第一节点了，第一次访问的时候我们已经让它指向了NULL，
	 所以到这结束。

	 但是这种方法修改了链表的指向
	 * 断链法
	 * @param pHead
	 * @return
	 */
	public ListNode EntryNodeOfLoop2(ListNode pHead){
		if (pHead == null || pHead.next == null){return null;}
		ListNode fast = pHead.next;
		ListNode slow = pHead;
		while(fast != null){
			slow.next = null;
			slow = fast;
			fast = fast.next;
		}
		return slow;
	}
}
