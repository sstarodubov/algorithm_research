package com.company.leetcode.M19;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        new Solution().removeNthFromEnd(ListNode.buildLinkedList(new int[]{1, 2, 3, 4, 5}), 5);
        System.out.println("tests passed");
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var dummy = head;
        var slow = dummy;
        var fast = dummy;
        int count = 0;
        while (count != n) {
            if (fast.next == null) {
                return dummy.next;
            }
            fast = fast.next;
            count++;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        var remove = slow.next;
        slow.next = remove.next;
        remove.next = null;
        return dummy;
    }
}
