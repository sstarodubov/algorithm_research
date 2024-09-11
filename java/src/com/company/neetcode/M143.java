package com.company.neetcode;

import com.company.ListNode;

public class M143 {

    public static void main(String[] args) {
        new M143().reorderList(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}));
    }

    public void reorderList(ListNode head) {
        ListNode slow = head,prev = null, fast = head, rev, dummy = new ListNode(-1);

        while (null != fast) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (null != fast) {
                fast = fast.next;
            }
        }
        if (prev != null) {
            prev.next = null;
        }
        rev = reverseList(slow);

        ListNode t1 = head, t2 = rev, cur = dummy;

        while (null != t1 && t2 != null) {
            cur.next = t1;
            t1 = t1.next;
            cur = cur.next;

            cur.next = t2;
            t2 = t2.next;
            cur = cur.next;

        }

        while (null != t1) {
            cur.next = t1;
            cur = cur.next;

            t1 = t1.next;
        }


        while (null != t2) {
            cur.next = t2;
            cur = cur.next;

            t2 = t2.next;
        }
        if (null != cur) {
            cur.next = null;
        }
        dummy.next = null;
    }

    public ListNode reverseList(ListNode head) {
        if (null == head) return null;
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
