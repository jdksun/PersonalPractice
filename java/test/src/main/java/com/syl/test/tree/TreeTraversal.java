package com.syl.test.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://blog.csdn.net/yangfeisc/article/details/44497429
 * https://www.cnblogs.com/yaobolove/p/6213936.html
 * https://blog.csdn.net/kerryfish/article/details/24309617
 */
public class TreeTraversal {

    /**
     * 循环　前序遍历
     * @param root
     */
    public void printPre(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (t != null || !stack.isEmpty()){
            if ( t != null){
                stack.push(t);
                System.out.print(t.val + " ");
                t = t.left;
            }else {
                t = stack.pop();
                t = t.right;
            }
        }
    }

    /**
     * 循环　中序遍历
     * @param root
     */
    public void printMid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (t!=null||!stack.isEmpty()){
            if (t != null){
                stack.push(t);
                t = t.left;
            }else {
                t = stack.pop();
                System.out.print(t.val + " ");
                t = t.right;
            }
        }
    }
    public void printAfter(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();//构造一个中间栈来存储逆后序遍历的结果
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        System.out.println(output.size());
        while (output.size() > 0) {
            System.out.print(output.pop().val+ " ");
        }
    }

    public void levelTravel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            System.out.print(t.val + " ");
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
    }
}
