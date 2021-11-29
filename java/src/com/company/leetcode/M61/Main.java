package com.company.leetcode.M61;

import com.company.ListNode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        ListNode l = new Solution().rotateRight(ListNode.buildLinkedList(new int[]{1, 2, 3}), 2000000000);
        assert l.val == 2;
        assert l.next.val == 3;
        assert l.next.next.val == 1;

        ListNode listNode = new Solution().rotateRight(ListNode.buildLinkedList(new int[]{1, 2}), 1);
        assert listNode.val == 2;
        assert listNode.next.val == 1;


        var node = new Solution().rotateRight(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}), 2);
        assert node.val == 4;
        assert node.next.val == 5;
        assert node.next.next.val == 1;
        assert node.next.next.next.val == 2;
        assert node.next.next.next.next.val == 3;
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n) space O(1)
    public ListNode rotateRight(ListNode node, int k) {
        if (k == 0 || node == null) return node;
        var dummy = new ListNode(-1);
        dummy.next = node;
        var cur = node;
        int size = 0;
        ListNode tail = null;
        while (cur != null) {
            size++;
            if (cur.next == null) tail = cur;
            cur = cur.next;
        }
        if (size == k) return node;
        if (size == 1) return node;

        if (k > size) k = k % size;
        if (k == 0) return node;

        var slow = dummy.next;

        for (int i = 1; i < size - k; i++) {
            slow = slow.next;
        }
        var newHead = slow.next;
        slow.next = null;
        dummy.next = newHead;
        tail.next = node;
        return dummy.next;
    }
}
