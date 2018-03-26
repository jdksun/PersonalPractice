package com.syl.practice;

/**
 * 题目：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Sword15 {

	private class Node{
		Node(int node){
			this.node = node;
			this.next = null;
		}
		int node;
		Node next;
	}
	private Node n ;
	public void push(int node) {
		Node newNode = new Node(node);
		newNode.next = n;
		n = newNode;
	}
	public void pop() {
		n = n.next;
	}

	public int top() {
		return n.node;
	}

	public int min() {
		if (n == null) throw new RuntimeException("stack is null");
		Node copy = n;
		int min = copy.node;
		while (copy!= null)
		{
			if (min > copy.node)
				min = copy.node;
			copy = copy.next;
		}
		return min;
	}
	
}
