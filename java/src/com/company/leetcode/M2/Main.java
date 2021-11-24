package com.company.leetcode.M2;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        new Solution().addTwoNumbers(ListNode.buildLinkedList(new int[]{2, 4, 3}), ListNode.buildLinkedList(new int[]{5, 6, 4}));
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) and space O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var fptr = l1;
        var sptr = l2;
        var dummyHead = new ListNode(-1);
        var cur = dummyHead;
        int rem = 0;
        while (fptr != null && sptr != null) {
            int newVal = fptr.val + sptr.val + rem;
            if (newVal >= 10) {
                rem = newVal / 10;
                newVal = newVal - 10;
            } else {
                if (rem > 0) rem--;
            }

            var node = new ListNode(newVal);
            cur.next = node;
            cur = node;
            fptr = fptr.next;
            sptr = sptr.next;
        }

        while (fptr != null) {
            int newVal = fptr.val + rem;
            if (newVal >= 10) {
                rem = newVal / 10;
                newVal = newVal - 10;
            } else {
                if (rem > 0) rem--;
            }
            var node = new ListNode(newVal);
            cur.next = node;
            cur = node;
            fptr = fptr.next;
        }

        while (sptr != null) {
            int newVal = sptr.val + rem;
            if (newVal >= 10) {
                rem = newVal / 10;
                newVal = newVal - 10;
            } else {
                if (rem > 0) rem--;
            }
            var node = new ListNode(newVal);
            cur.next = node;
            cur = node;
            sptr = sptr.next;
        }
        if (rem == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}