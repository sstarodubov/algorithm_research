package com.company.neetcode;

import com.company.ListNode;

public class M19 {

    public static void main(String[] args) {
        ListNode listNode = new M19().removeNthFromEnd(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}), 5);
        System.out.println(listNode);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;

        while (null != cur) {
            cur = cur.next;
            len++;
        }

        ListNode dummy = new ListNode(), prev = null;
        dummy.next = head;

        cur = dummy.next;
        prev = dummy;
        for (int i = 0; i < len - n; i++) {
            prev = prev.next;
            cur = cur.next;
        }

        prev.next = cur.next;

        return dummy.next;
    }
}
