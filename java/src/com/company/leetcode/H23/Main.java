package com.company.leetcode.H23;

import com.company.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Main {
    public static void main(String[] args) {
        ListNode merge = new Solution().mergeKLists(new ListNode[]{ListNode.buildLinkedList(new int[]{1, 2, 3}), ListNode.buildLinkedList(new int[]{4, 5, 6, 7})});

        ListNode listNode = new Solution().mergeKLists(new ListNode[]{ListNode.buildLinkedList(new int[]{1, 4, 5}),
                ListNode.buildLinkedList(new int[]{1, 3, 4}),
                ListNode.buildLinkedList(new int[]{2, 6})});

        assert listNode.val == 1;
        assert listNode.next.val == 1;
        assert listNode.next.next.val == 2;
        assert listNode.next.next.next.val == 3;
        assert listNode.next.next.next.next.val == 4;
        assert listNode.next.next.next.next.next.val == 4;
        assert listNode.next.next.next.next.next.next.val == 5;
        assert listNode.next.next.next.next.next.next.next.val == 6;
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n log n) space O(n log n)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        if (lists.length == 1) return lists[0];
        var middle = lists.length / 2;
        var leftNode = mergeKLists(Arrays.copyOfRange(lists, 0, middle));
        var rightNode = mergeKLists(Arrays.copyOfRange(lists, middle, lists.length));

        return merge(leftNode, rightNode);
    }


    public ListNode merge(ListNode list1, ListNode list2) {
        var dummy = new ListNode(-1);
        var ptr1 = list1;
        var ptr2 = list2;
        var tail = dummy;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                tail.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                tail.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }
            tail = tail.next;
        }

        while (ptr1 != null) {
            tail.next = new ListNode(ptr1.val);
            ptr1 = ptr1.next;
            tail = tail.next;
        }

        while (ptr2 != null) {
            tail.next = new ListNode(ptr2.val);
            ptr2 = ptr2.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}