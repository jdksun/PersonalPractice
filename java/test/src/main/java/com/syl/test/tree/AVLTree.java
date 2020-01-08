package com.syl.test.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 参考博文 https://blog.csdn.net/javazejian/article/details/53892797
 */
public class AVLTree {

    public static void main(String[] args) {
        int[] a = {8,5,10,3,6,12,18};
        AVLTree t = new AVLTree();
        for (int i=0;i<a.length;i++){
            t.insert(a[i]);
        }
        t.print();
        t.printTree();
    }

    private static final int AVL = 1;
    public AVLTree() {
        root = null;
    }

    private Tree root;

    public void remove(int data){
        root = remove(data,root);
    }

    private Tree remove(int data, Tree t) {
        if (t == null) return t;
        if (data < t.data){
            t.left = remove(data,t.left);
        }else if (data > t.data){
            t.right = remove(data,t.right);
        }else if (t.left != null && t.right != null){
            t.data = findMin(t.right).data;
            t.right = remove(t.data,t.right);
        }else
            t = t.left == null ? t.right : t.left;
        return balance(t);
    }

    public void insert(int data){
        root = insert(data,root);
    }

    private Tree insert(int x,Tree t){
        if (t == null) return new Tree(x);
        if ( x >t.data){
            t.right = insert(x,t.right);
        }else
            t.left = insert(x,t.left);
        return balance(t);
    }

    private Tree balance(Tree t) {
        if (t == null) return null;
        if (height(t.left) - height(t.right) > AVL){
            if (height(t.left.left) >= height(t.left.right)){
                t = singleRotateLeft(t);
            }else
                t = doubleRotateWithLeft(t);
        }else if (height(t.right) - height(t.left) > AVL){
            if (height(t.right.right) >= height(t.right.left) ){
                t = singleRotateRight(t);
            }else
                t = doubleRotateWithRight(t);
        }
        t.height = Math.max(height(t.left),height(t.right))+1;
        return t;
    }


    /**
     * 左左单旋转(LL旋转) w变为x的根结点, x变为w的右子树
     * @param x
     */
    private Tree singleRotateLeft(Tree x){
        Tree w = x.left;
        x.left = w.right;
        w.right = x;
        x.height = Math.max(height(x.left),height(x.right))+1;
        w.height = Math.max(height(w.left),x.height)+1;
        return w;
    }

    /**
     * 右右单旋转(RR旋转) x变为w的根结点, w变为x的左子树
     * @return
     */
    private Tree singleRotateRight(Tree w){
        Tree x = w.right;
        w.right = x.left;
        x.left = w;
        w.height = Math.max(height(w.right),height(w.left))+1;
        x.height = Math.max(height(x.right),w.height) + 1;
        return x;
    }
    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     * @return
     */
    private Tree doubleRotateWithLeft(Tree x){
        x.left = singleRotateRight(x.left);
        return singleRotateLeft(x);
    }
    /**
     * 右左旋转(RL旋转)
     * @param x
     * @return
     */
    private Tree doubleRotateWithRight(Tree x){
        //先进行LL旋转
        x.right=singleRotateLeft(x.right);
        //再进行RR旋转
        return singleRotateRight(x);
    }
    private int height(Tree t){
        return t == null ? -1:t.height;
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


    public static class Tree{
        public int data;
        public Tree left;
        public Tree right;
        public int height;
        public Tree(int data,Tree left,Tree right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Tree(int data) {
            this.data = data;
            this.left = this.right = null;
        }
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

    /**
     * 打印 中序遍历
     */
    public void printTree(){printTree(root);
        System.out.println();}
}
