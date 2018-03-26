package com.syl.practice;

import com.syl.tools.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sword14Test {
    @Test
    public void findFirstCommonNode() throws Exception {

        ListNode a = new ListNode(0);
        a.next = new ListNode(2);
        ListNode b = new ListNode(1);
        b.next = new ListNode(1);
        Sword14 s = new Sword14();
        assertEquals(1,s.FindFirstCommonNode(a,b).val);

    }

}