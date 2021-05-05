package com.company;

import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        var exp = new ReverseLinkedList();

        ListNode listNode = exp.reverseList(head);
        assert 5 == listNode.val;
        assert 4 == listNode.next.val;
        assert 3 == listNode.next.next.val;
        assert 2 == listNode.next.next.next.val;
        assert 1 == listNode.next.next.next.next.val;
        assert null == listNode.next.next.next.next.next;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
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
