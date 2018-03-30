package com.syl.practice;

import com.syl.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
public class Sword1 {
	/**
	 * 我的方法
	 * 递归
	 * @param root
	 * @return
	 */
	public int TreeDepth(TreeNode root) {
        if(root == null)  return 0;  
	       int DepthLeft = TreeDepth(root.left);  
	       int DepthRight = TreeDepth(root.right);  
	        return 1 + (DepthLeft > DepthRight ? DepthLeft : DepthRight);  
    }

	/**排名第一
	 * 层次遍历
	 	将每一层都看作一个队列，让队列依次弹出，当队列为空时跳出循环
	 * @param pRoot
	 * @return
	 */
	public int TreeDepath(TreeNode pRoot) {
		if (pRoot == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		int deep = 0;
		while(!queue.isEmpty()) {
			deep++;
			int len = queue.size();
			while (len-- > 0){
				TreeNode next = queue.poll();
				if (next.left != null) {
					queue.add(next.left);
				}
				if (next.right != null) {
					queue.add(next.right);
				}
			}
		}
		return deep;
	}

	/**
	 * 栈的形式
	 * 不推荐使用这种形式 for(int i = 0;i < stack.size(); i++)
	 * 因为stack.size()在每次for循环中是会改变的，造成利用此方法计算其他类似算法的时候，造成差错
	 * @param root
	 * @return
	 */
	public int TreeDepath2(TreeNode root) {
		if(root == null)  return 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int deep = 0;
		while(!stack.isEmpty()) {
			deep++;
			for(int i = 0;i < stack.size(); i++) {
				TreeNode treeNode = stack.pop();
				if (treeNode.left != null) {
					stack.push(treeNode.left);
				}
				if (treeNode.right != null) {
					stack.push(treeNode.right);
				}
			}
		}
		return deep;
	}

	/**
	 * 层次遍历 减少循环
	 * @param root
	 * @return
	 */
	public int TreeDepath3(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int deep = 0;
		int count = 0;
		int nextCount = 1;
		while (!queue.isEmpty()){
			TreeNode t = queue.poll();
			count++;
			if (t.left != null) queue.add(t.left);
			if (t.right != null) queue.add(t.right);
			if (count == nextCount){
				count = 0;
				nextCount = queue.size();
				deep++;
			}
		}
		return deep;
	}

}
