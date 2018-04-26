package com.syl.test.tree;

public class BiaoDaShiTree {





    class Node{
        public Node left;
        public Node right;
        public String data;

        public Node(Node left, Node right, String data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
