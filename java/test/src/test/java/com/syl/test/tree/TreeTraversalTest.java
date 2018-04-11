package com.syl.test.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTraversalTest {

    private TreeTraversal s;
    private TreeNode root = new TreeNode(3);
    @Before
    public void init(){
        s = new TreeTraversal();
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
    }
    @Test
    public void printPre() throws Exception {
        s.printPre(root);
    }

    @Test
    public void printMid() throws Exception {
        s.printMid(root);
    }

    @Test
    public void printAfter() throws Exception {
        s.printAfter(root);
    }
    @Test
    public void levelTravel() throws Exception {
        s.levelTravel(root);
    }

}