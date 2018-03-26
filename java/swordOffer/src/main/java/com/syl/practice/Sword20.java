package com.syl.practice;

import com.syl.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：把二叉树打印成多行
 * 目描述从上到下按层打印二叉树，
 * 同一层结点从左至右输出。每一层输出一行。
 */
public class Sword20 {
	/**
	 * 我的答案,层次遍历,但是与一般答案相比多了一个while循环，时间复杂度大大增加
	 * @param pRoot
	 * @return
	 */
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (pRoot == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		while (!queue.isEmpty()){
			ArrayList<Integer> array = new ArrayList<>();
			int num = queue.size();
			for (int i = 0;i< num;i++){
				TreeNode t = queue.poll();
				array.add(t.val);
				if (t.left != null) queue.add(t.left);
				if(t.right != null) queue.add(t.right);
			}
			if (array.size() != 0) list.add(array);
		}
		return list;
	}

	ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (pRoot == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> array = new ArrayList<>();
		queue.add(pRoot);
		int now = 1;
		int next = 0;
		while (!queue.isEmpty()){
			now--;
			TreeNode t = queue.poll();
			array.add(t.val);
			if (t.left != null){
				queue.add(t.left);
				next++;
			}
			if (t.right != null){
				queue.add(t.right);
				next++;
			}
			if (now == 0){
				//必须要指向一个新的ArrayList引用，否则指向array时，当下面的array.clear()调用的时候，list
				//array引用是同一个引用，会使引用里的内容清空
				list.add(new ArrayList<>(array));
				now = next;
				next = 0;
				array.clear();
			}
		}
		return list;
	}
}
