package com.syl.test.tree;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树（Binary Sort Tree）又称二叉查找树
 */
public class BSTree {

    public static void main(String[] args) {
        BSTree root = new BSTree();
        int[] a = {6,2,8,1,4,3};
        for (int i = 0 ;i<a.length;i++){
            root.insert(a[i]);
        }
        root.print();
        root.printTree();
        root.insert(5);
        System.out.println("-----------------");
        root.remove(6);
        root.print();
        root.printTree();

    }

    /**
     * 打印 中序遍历
     */
    public void printTree(){printTree(root);
        System.out.println();}

    /**
     * 中序遍历
     * @param root
     */
    private void printTree(Tree root){
        if (root != null){
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }
    public Tree root;

    public BSTree(){ root = null;}
    public boolean isEmpty(){ return root == null;}

    public void makeEmpty(){ root = null;}

    public boolean contains(int x){
        return  contains(x,root);
    }


    private boolean contains(int x, Tree root) {
        if ( root == null)
            return false;
        if (x < root.data)
            return contains(x,root.left);
        else if (x > root.data)
            return contains(x,root.right);
        else
            return true;
    }

    /**
     * 插入
     * @param x
     */
    public void insert(int x){root = insert(x,root);}
    private Tree insert(int x,Tree root){
        if (root == null){
            return new Tree(x,null,null);
        }
        if(contains(x)){
            throw new RuntimeException("BST has contains this data");
        }
        if (x < root.data)
            root.left = insert(x,root.left);
        else
            root.right = insert(x,root.right);
        return root;
    }

    public void remove(int x){
        root = remove(x,root);
    }

    private Tree remove(int x,Tree t){
        if (t == null) return null;
        if (t.data > x){
            t.left =  remove(x,t.left);
        }else if (t.data < x){
            t.right = remove(x,t.right);
        }else if(t.left != null && t.right != null){
            t.data = findMin(t.right).data;
            t.right = remove(t.data,t.right);
        }else
            t = t.left != null ? t.left : t.right;
        return t;
    }

    private Tree findMin(Tree root){
        if (root == null) return null;
        else if (root.left == null){
            return root;
        }
        return findMin(root.left);
    }
    private Tree findMax(Tree root){
        if (root == null) return null;
        while (root.right != null)
            root = root.right;
        return root;
    }
    /**
     * 打印整个树
     */
    public void print(){
        if (root != null){
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);
            int count = 0;
            int nextCount = 1;
            while (!queue.isEmpty()){
                Tree t = queue.poll();
                count++;
                System.out.print(t.data + " ");
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
                if (count == nextCount){
                    count = 0;
                    nextCount = queue.size();
                    System.out.println();
                }
            }
        }
    }
    public static class Tree{
        public int data;
        public Tree left;
        public Tree right;

        public Tree(int data,Tree left,Tree right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
