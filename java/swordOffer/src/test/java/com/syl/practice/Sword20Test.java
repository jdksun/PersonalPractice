package com.syl.practice;

import com.syl.tools.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Sword20Test {
    @Test
    public void print() throws Exception {
        Sword20 s = new Sword20();
        TreeNode root = new TreeNode(8);
         root.left = new TreeNode(6);
         root.right = new TreeNode(10);
         root.left.left = new TreeNode(5);
         root.left.right = new TreeNode(7);
         root.right.left = new TreeNode(9);
         root.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(8);
        list.add(a);
        a = new ArrayList<>();
        a.add(6);
        a.add(10);
        list.add(a);
        a = new ArrayList<>();
        a.add(5);
        a.add(7);
        a.add(9);
        a.add(11);
        list.add(a);
        assertEquals(list,s.Print(root));

        assertEquals(list,s.Print2(root));
    }

}