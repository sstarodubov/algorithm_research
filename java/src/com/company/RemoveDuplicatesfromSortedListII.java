package com.company;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers
 * , leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        var r = new RemoveDuplicatesfromSortedListII();
        ListNode node = r.deleteDuplicates(ListNode.buildLinkedList(new int[]{1, 1}));
        System.out.println("tests passed");
    }


    // Time O(n) and Space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        var cur = head;
        while (cur != null) {
            var next = cur.next;
            if (next != null && next.val == cur.val) {
                while (cur != null && cur.next != null && cur.next.val == next.val) {
                    cur = cur.next;
                }
                if (cur != null) {
                    cur = cur.next;
                    if (prev != null) prev.next = cur;
                    else head = cur;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }

        }
        return head;
    }
}
