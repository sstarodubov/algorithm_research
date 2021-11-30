package com.company.leetcode.H25;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {

        var node = new Solution().reverseKGroup(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7}), 3);
        assert node.val == 3;
        assert node.next.val == 2;
        assert node.next.next.val == 1;
        assert node.next.next.next.val == 6;
        assert node.next.next.next.next.val == 5;
        assert node.next.next.next.next.next.val == 4;
        assert node.next.next.next.next.next.next.val == 7;

        var n3 = new Solution().reverseKGroup(ListNode.buildLinkedList(new int[]{1, 2, 3, 4}), 2);
        assert n3.val == 2;
        assert n3.next.val == 1;
        assert n3.next.next.val == 4;
        assert n3.next.next.next.val == 3;

        var n2 = new Solution().reverseKGroup(ListNode.buildLinkedList(new int[]{1, 2}), 2);
        assert n2.val == 2;
        assert n2.next.val == 1;


        var node1 = new Solution().reverseKGroup(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7}), 2);
        assert node1.val == 2;
        assert node1.next.val == 1;
        assert node1.next.next.val == 4;
        assert node1.next.next.next.val == 3;
        assert node1.next.next.next.next.val == 6;
        assert node1.next.next.next.next.next.val == 5;
        assert node1.next.next.next.next.next.next.val == 7;
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n ^ 2) , space O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        var dummy = new ListNode(-1);
        dummy.next = head;
        var start = dummy.next;
        var end = dummy.next;
        var front = dummy;
        int count = 0;
        while (end != null && count < k - 1) {
            count++;
            end = end.next;
        }
        while (end != null) {
            var backTmp = end.next;
            ListNode[] list = reverse(front, start, end);
            front.next = list[0];
            if (list[1] != null) list[1].next = backTmp;
            front = list[1];
            if (list[1] != null) start = list[1].next;
            end = list[1];

            int c = 0;
            while (end != null && c < k) {
                c++;
                end = end.next;
            }
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode dummy, ListNode start, ListNode end) {
        dummy.next = start;
        var cur = start;
        var tail = end.next;
        while (cur != tail) {
            var tmp = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = tmp;
        }
        start.next = null;
        return new ListNode[]{end, start};
    }
}