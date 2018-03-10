package com.syl.practice;

import com.syl.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
 二叉树的镜像定义：源二叉树
   8
 /  \
 6   10
 / \  / \
 5  7 9 11
 镜像二叉树
   8
 /  \
 10   6
 / \  / \
 11 9 7  5
 */
public class Sword3 {

	public static void main(String[] args) {
		
	}

	/**
	 * 我的答案
	 * 递归
	 * @param root
	 */
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}

	/**
	 * 我的答案 2
	 * 分层
	 * @param root
	 */
	public void Mirror2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				TreeNode rNode2 = queue.poll();
				if (rNode2 == null) continue;
				TreeNode temp = rNode2.left;
				rNode2.left = rNode2.right;
				rNode2.right = temp;
				if (rNode2.left != null) {
					queue.add(rNode2.left);
				}
				if (rNode2.right != null) {
					queue.add(rNode2.right);
				}
			}
		}
	}

	/**
	 * 排名第一答案
	 *分层
	 * @param root
	 */
	public void Mirror3(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()) {
			TreeNode node = stack.pop();
			if(node.left != null || node.right != null) {
				TreeNode nodeLeft = node.left;
				TreeNode nodeRight = node.right;
				node.left = nodeRight;
				node.right = nodeLeft;
			}
			if(node.left != null) stack.push(node.left);
			if(node.right != null) stack.push(node.right);
		}
	}

	/**
	 * 根据答案改进第二种方法
	 * @param rNode
	 */
	public void Mirror4(TreeNode rNode) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(rNode);
		while (!queue.isEmpty()) {
			TreeNode rNode2 = queue.poll();
			if (rNode2 == null) continue;
			TreeNode temp = rNode2.left;
			rNode2.left = rNode2.right;
			rNode2.right = temp;
			if (rNode2.left != null) {
				queue.add(rNode2.left);
			}
			if (rNode2.right != null) {
				queue.add(rNode2.right);
			}
		}
	}
}
