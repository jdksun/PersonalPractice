package com.syl.practice;

import com.syl.tools.TreeNode;

/**
 * 题目：平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Sword12 {
	/**
	 * 我的答案
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null){
			return true;
		}
		int left = getDeep(root.left);
		int right = getDeep(root.right);
		int dif = left - right;
		if (dif > 1 || dif < -1) return false;
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}


	public int getDeep(TreeNode root){
		if (root == null) return 0;
		int left = getDeep(root.left);
		int right = getDeep(root.right);
		return left > right ? left + 1 : right + 1;
	}

	/**
	 * 排名第一
	 */
	public boolean IsBalanced_Solution2(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
			return false;
		return IsBalanced_Solution2(root.left) && IsBalanced_Solution2(root.right);
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * 排名第二
	 */
	private class Holder {
		int n;
	}
	boolean f(TreeNode root, Holder h) {
		if (root == null) {
			h.n = 0;
			return true;
		}
		Holder l = new Holder(), r = new Holder();
		if (f(root.left, l) && f(root.right, r)) {
			if (l.n - r.n > 1 || r.n - l.n > 1)
				return false;
			h.n += (l.n > r.n ? l.n : r.n) + 1;
			return true;
		}
		return false;
	}
}
