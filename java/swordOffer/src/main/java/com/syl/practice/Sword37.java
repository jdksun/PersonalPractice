package com.syl.practice;

import com.syl.tools.TreeNode;
/**
 * 题目：从上到下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Sword37 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if (temp.left!=null){
				queue.add(temp.left);
			}
			if (temp.right != null){
				queue.add(temp.right);
			}
		}
		return list;
	}
	
	
}
