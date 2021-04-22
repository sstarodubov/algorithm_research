package com.company;

public class SortList {
    public static void main(String[] args) {
        var l1 = ListNode.buildLinkedList(new int[]{4, 2, 3, 1});
        ListNode n = sortList(l1);
        assert 1 == n.val : "1";
        assert 2 == n.next.val : "2";
        assert 3 == n.next.next.val : "3";
        assert 4 == n.next.next.next.val : "4";

        ListNode n2 = sortList(null);
        assert null == n2 : "n2 is null";

        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(1)
    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, prev = null;
        int bound = Integer.MAX_VALUE;
        int count = 0;
        while (true) {
            boolean isSwapped = false;
            while (cur.next != null && count < bound) {
                if (cur.val > cur.next.val) {
                    if (prev == null) head = cur.next;
                    swapNodeWithNext(cur, cur.next, prev);
                    if (prev == null) prev = head;
                    else prev = prev.next;
                    isSwapped = true;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
                count++;
            }
            bound = count - 1;
            if (!isSwapped) return head;
            else {
                cur = head;
                prev = null;
                count = 0;
            }
        }
    }

    public static void swapNodeWithNext(ListNode cur, ListNode next, ListNode prev) {
        if (cur == null) return;
        if (next == null) return;
        var nn = next.next;
        next.next = cur;
        cur.next = nn;
        if (prev != null) prev.next = next;
    }
}
