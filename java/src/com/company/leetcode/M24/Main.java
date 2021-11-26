package com.company.leetcode.M24;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new Solution().swapPairs(ListNode.buildLinkedList(new int[]{1, 2, 3, 4}));
        ListNode node = new Solution().swapPairs(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}));

        assert 2 == listNode.val;
        assert 1 == listNode.next.val;
        assert 4 == listNode.next.next.val;
        assert 3 == listNode.next.next.next.val;

        assert 2 == node.val;
        assert 1 == node.next.val;
        assert 4 == node.next.next.val;
        assert 3 == node.next.next.next.val;
        assert 5 == node.next.next.next.next.val;

        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) , space O(1)
    public ListNode swapPairs(ListNode node) {
        if (node == null || node.next == null) return node;

        var dummy = new ListNode(-1);
        var bback = dummy;
        var front = node.next;
        var back = node;

        while (front != null) {
            var tmp = front.next;
            bback.next = front;
            front.next = back;
            back.next = tmp;

            if (tmp == null) return dummy.next;
            front = tmp.next;
            back = tmp;
            bback = bback.next.next;
        }
        return dummy.next;
    }
}
