package com.company.leetcode.E83;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        var node = new Solution().deleteDuplicates(ListNode.buildLinkedList(new int[]{1, 1, 2}));
        assert node.val == 1;
        assert node.next.val == 2;

        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) , space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        var dummy = new ListNode(-100000);
        dummy.next = head;

        var back = dummy;
        var front = head;

        while (front != null) {
            if (back.val == front.val) {
                back.next = front.next;
                front = front.next;
            } else {
                back = back.next;
                front = front.next;
            }
        }
        return dummy.next;
    }
}
