package com.syl.practice;

import java.util.Stack;

/**
 * 题目 ：用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class Sword6 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	/**
	 * 我的答案
	 * @param node
	 */
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int first = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return first;
	}

	/**
	 * 排名第一答案
	 * @param node
	 */
	public void push2(int node) {
		stack1.push(node);
	}

	public int pop2() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int first = stack2.pop();
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return first;
	}

	/**
	 * 排名第二答案
	 * @param node
	 */
	public void push3(int node) {
		stack1.push(node);
	}

	public int pop3() {
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				int node = stack1.pop();
				stack2.add(node);
			}
		}

		return stack2.pop();
	}
}
