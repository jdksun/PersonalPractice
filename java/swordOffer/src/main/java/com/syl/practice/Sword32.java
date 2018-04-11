package com.syl.practice;

import com.syl.tools.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Queue;
import java.util.Stack;

/**
 * 题目：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Sword32 {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode t = pRootOfTree;
		boolean isFirst = true;
		TreeNode pre = null;
		while (t!=null||!stack.isEmpty()){
			while(t!=null){
				stack.push(t);
				t = t.left;
			}
			t = stack.pop();
			if (isFirst){
				pRootOfTree = t;
				pre = pRootOfTree;
				isFirst = false;
			}else {
				pre.right = t;
				t.left = pre;
				pre = t;
			}
			t = t.right;
		}
		return pRootOfTree;
	}

	public TreeNode Convert2(TreeNode root) {
		if(root==null)
			return null;
		if(root.left==null&&root.right==null)
			return root;
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode left = Convert(root.left);
		TreeNode p = left;
		// 2.定位至左子树双链表最后一个节点
		while(p!=null&&p.right!=null){
			p = p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if(left!=null){
			p.right = root;
			root.left = p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right = Convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if(right!=null){
			right.left = root;
			root.right = right;
		}
		return left!=null?left:root;
	}

}
