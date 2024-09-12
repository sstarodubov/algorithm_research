package com.company.neetcode;

import com.company.ListNode;

public class M2 {

    public static void main(String[] args) {
        var result = new M2().addTwoNumbers(ListNode.buildLinkedList(new int[]{2, 4, 3}),
                ListNode.buildLinkedList(new int[]{5, 6, 4}));
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         var dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (null != l1 && null != l2) {
            var v = (l1.val + l2.val + carry);
            var node = new ListNode(v % 10);
            carry = v > 9 ? 1 : 0;
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (null != l1) {
            var v = (l1.val + carry);
            var node = new ListNode((v) % 10);
            carry = v > 9 ? 1 : 0;
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }

        while (null != l2) {
            var v = (l2.val + carry);
            var node = new ListNode((v) % 10);
            carry = v > 9 ? 1 : 0;
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
