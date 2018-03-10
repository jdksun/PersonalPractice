package com.syl.practice;

import com.syl.tools.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Sword12Test {
    @Test
    public void isBalanced_Solution() throws Exception {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        assertTrue(new Sword12().IsBalanced_Solution(root));
        assertTrue(new Sword12().IsBalanced_Solution2(root));
    }

}
