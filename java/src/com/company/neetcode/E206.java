package com.company.neetcode;

import com.company.ListNode;

public class E206 {

    public static void main(String[] args) {
        ListNode listNode = new E206().reverseList(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}));
        System.out.println(listNode);
    }
    public ListNode reverseList(ListNode head) {
        var dummy = new ListNode(-1);
        ListNode t, cur = head;
        while (cur != null) {
            t = dummy.next;
            dummy.next = cur;
            cur = cur.next;
            dummy.next.next = t;
        }

        return dummy.next;
    }
}
