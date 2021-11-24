package com.company.leetcode.E21;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        new Solution().mergeTwoLists(ListNode.buildLinkedList(new int[]{1, 2, 4}), ListNode.buildLinkedList(new int[]{1, 3, 4}));
        System.out.println("tests passed");
    }
}

class Solution {

    // Time (list1.size + list2.size) , space O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        var first = list1;
        var second = list2;
        var dummy = new ListNode(-1);
        var cur = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                var tmp = first;
                first = first.next;
                tmp.next = null;
                cur.next = tmp;
                cur = cur.next;
            } else {
                var tmp = second;
                second = second.next;
                tmp.next = null;
                cur.next = tmp;
                cur = cur.next;
            }
        }
        if (first != null) {
            cur.next = first;
            return dummy.next;
        }

        if (second != null) {
            cur.next = second;
            return dummy.next;
        }

        return dummy.next;
    }
}
