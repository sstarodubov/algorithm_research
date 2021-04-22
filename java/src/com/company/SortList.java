package com.company;

public class SortList {

    // Time O(n^2) and Space O(1)
    public static ListNode sortListLikeABubble(ListNode head) {
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

    // MergeSort
    // Time O(n * log n) and space O(1)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
