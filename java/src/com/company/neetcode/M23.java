package com.company.neetcode;

import com.company.ListNode;

public class M23 {

    public static void main(String[] args) {
        ListNode listNode = new M23().mergeKLists(new ListNode[]{
                ListNode.buildLinkedList(new int[]{1, 2, 3, 4}),
                ListNode.buildLinkedList(new int[]{2, 3, 4, 5}),
                ListNode.buildLinkedList(new int[]{1, 2, 3, 4}),
                ListNode.buildLinkedList(new int[]{2, 3, 4, 5}),
        });

        System.out.println(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return split(lists, 0, lists.length);
    }

    ListNode split(ListNode[] lists, int left, int right) {
        int len = right - left;
        if (len == 1) {
            return lists[left];
        }

        int m = (left + right) / 2;
        ListNode splitLeft = split(lists, left, m);
        ListNode splitRight = split(lists, m, right);

        return merge(splitLeft, splitRight);
    }

    ListNode merge(ListNode l, ListNode r) {
        if (null == l) {
            return r;
        }

        if (null == r) {
            return l;
        }
        var dummy = new ListNode();
        ListNode cur = dummy;

        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }

            cur = cur.next;
        }

        while (l != null) {
            cur.next = l;
            l = l.next;
            cur = cur.next;
        }


        while (r != null) {
            cur.next = r;
            r = r.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
