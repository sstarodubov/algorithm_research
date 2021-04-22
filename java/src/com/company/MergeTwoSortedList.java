package com.company;

public class MergeTwoSortedList {
    public static void main(String[] args) {

        // basic case
        var l1 = ListNode.buildLinkedList(new int[]{1, 2, 4});
        var l2 = ListNode.buildLinkedList(new int[]{1, 3, 4});
        ListNode ans = mergeTwoLists(l1, l2);
        assert ans.val == 1 : "1";
        assert ans.next.val == 1 : "2";
        assert ans.next.next.val == 2 : "3";
        assert ans.next.next.next.val == 3 : "4";
        assert ans.next.next.next.next.val == 4 : "5";
        assert ans.next.next.next.next.next.val == 4 : "6";
        assert ans.next.next.next.next.next.next == null : "7";

        // two lists  equals null

        ListNode node = mergeTwoLists(null, null);
        assert node == null : "node eq null";

        // one list equals null

        l2 = ListNode.buildLinkedList(new int[] {0});
        var n = mergeTwoLists(null, l2);
        assert n.val == 0 : "node is 0";
        assert n.next == null : "node is null";
        System.out.println("tests passed");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode leftPtr, rightPtr, head, cur;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            leftPtr = l1.next;
            rightPtr = l2;
        } else {
            head = new ListNode(l2.val);
            rightPtr = l2.next;
            leftPtr = l1;
        }

        cur = head;

        while (leftPtr != null && rightPtr != null) {
            if (leftPtr.val <= rightPtr.val) {
                var node = new ListNode(leftPtr.val);
                cur.next = node;
                cur = node;
                leftPtr = leftPtr.next;
            } else {
                var node = new ListNode(rightPtr.val);
                cur.next = node;
                cur = node;
                rightPtr = rightPtr.next;
            }
        }

        while (rightPtr != null) {
            var node = new ListNode(rightPtr.val);
            cur.next = node;
            cur = node;
            rightPtr = rightPtr.next;
        }

        while (leftPtr != null) {
            var node = new ListNode(leftPtr.val);
            cur.next = node;
            cur = node;
            leftPtr = leftPtr.next;
        }

        return head;
    }
}
