package com.company.neetcode;

import com.company.ListNode;

public class H25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        var dummy = new ListNode();
        dummy.next = head;
        ListNode prev, cur, next;

        prev = dummy;
        cur = dummy;
        next = dummy.next;
        int i = 0;
        while (next != null && i < k) {
            cur = cur.next;
            next = next.next;
            i++;
        }

        ListNode beforeBegin;
        while (true) {
            beforeBegin = prev.next;
            cur.next = null;
            reverseList(prev.next);
            prev.next = cur;

            beforeBegin.next = next;


            prev = beforeBegin;
            cur = prev;

            for (int j = 0; j < k; j++) {
                if (next == null) {
                    return dummy.next;
                }
                cur = cur.next;
                next = next.next;
            }
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = head;
        ListNode cur = head.next;
        if (cur == null) return dummy;
        dummy.next = null;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = dummy;
            dummy = tmp;
        }

        return dummy;
    }
}
