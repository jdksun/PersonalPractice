package com.syl.practice;

import com.syl.tools.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sword32Test {
    @Test
    public void convert() throws Exception {
        TreeNode root = new TreeNode(3);
         root.left = new TreeNode(2);
         root.right = new TreeNode(5);
         root.left.left = new TreeNode(1);
         root.right.left = new TreeNode(4);
         root.right.right = new TreeNode(6);
         Sword32 s = new Sword32();
         s.Convert2(root);

    }

}