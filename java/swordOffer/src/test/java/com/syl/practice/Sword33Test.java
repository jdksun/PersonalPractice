package com.syl.practice;

import com.syl.tools.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sword33Test {
    @Test
    public void merge() throws Exception {
        Sword33 s = new Sword33();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next = new ListNode(7);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head.next.next = new ListNode(6);

        ListNode result = s.Merge(head,head2);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

}