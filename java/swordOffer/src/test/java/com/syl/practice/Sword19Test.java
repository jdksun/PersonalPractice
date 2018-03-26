package com.syl.practice;

import com.syl.tools.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sword19Test {
    @Test
    public void isSymmetrical2() throws Exception {
        Sword19 s = new Sword19();
        TreeNode root = new TreeNode(1);
         root.left = new TreeNode(1);
         root.right = new TreeNode(1);
//         root = new TreeNode(1);
//         root = new TreeNode(1);
//         root = new TreeNode(1);
        assertTrue(s.isSymmetrical2(root));
    }

}