package com.syl.practice;

import com.syl.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：对称二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Sword19 {
	/**
	 * 递归
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) return true;
		return f(pRoot.left,pRoot.right);
	}

	boolean f(TreeNode left,TreeNode right){
		if (left == null && right == null) return true;
		if (left != null && right != null)
			return left.val == right.val && f(left.left,right.right) &&
					f(left.right,right.left);
		return false;
	}

	/**
	 *要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先
	 * 右后左两种方法，只要两次结果相等就说明这棵树是一颗对称二叉树。
	 */
	boolean isSymmetrical2(TreeNode pRoot) {
		if (pRoot == null) return true;
		Queue<TreeNode> left_Q = new LinkedList<>();
		Queue<TreeNode> right_Q = new LinkedList<>();
		TreeNode left,right;
		left_Q.add(pRoot.left);
		right_Q.add(pRoot.right);
		while (!left_Q.isEmpty() && !right_Q.isEmpty()){
			left = left_Q.poll();
			right = right_Q.poll();
			if (left == null && right == null) continue;
			if (left == null || right == null) return false;
			if (left.val != right.val) return false;
			left_Q.add(left.left);
			left_Q.add(left.right);
			right_Q.add(right.right);
			right_Q.add(right.left);
		}
		return true;
	}
}
