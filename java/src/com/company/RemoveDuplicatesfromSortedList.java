package com.company;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {

        ListNode listNode = deleteDuplicates(ListNode.buildLinkedList(new int[]{1, 1, 2}));
        System.out.println("tests passed");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        var cur = head;
        while (cur != null) {
            var next = cur.next;
            if (next != null && next.val == cur.val) {
                cur.next = next.next;
            } else cur = cur.next;
        }
        return head;
    }
}
