package com.company;

public class MergeKSortedLinkedList {
    public static void main(String[] args) {

        var l1 = ListNode.buildLinkedList(new int[]{1, 4, 5});
        var l2 = ListNode.buildLinkedList(new int[]{1, 3, 4});
        var l3 = ListNode.buildLinkedList(new int[]{2, 6});
        var ll = new ListNode[]{l1, l2, l3};

        ListNode a = mergeKLists(new ListNode[] {});
        assert a == null;

        ListNode ans = mergeKLists(ll);
        assert ans.val == 1;
        assert ans.next.val == 1;
        assert ans.next.next.val == 2;
        assert ans.next.next.next.val == 3;
        assert ans.next.next.next.next.val == 4;
        assert ans.next.next.next.next.next.val == 4;
        assert ans.next.next.next.next.next.next.val == 5;
        assert ans.next.next.next.next.next.next.next.val == 6;
        assert ans.next.next.next.next.next.next.next.next == null;

        System.out.println("tests passed");
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKListHelper(lists, 0, lists.length - 1);
    }

    // Time (n * log n) and Space O(n)
    public static ListNode mergeKListHelper(ListNode[] list, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) return list[leftIdx];

        int midIdx = (leftIdx + rightIdx) / 2;
        var leftNode = mergeKListHelper(list, leftIdx, midIdx);
        var rightNode = mergeKListHelper(list, midIdx + 1, rightIdx);
        return merge2LL(leftNode, rightNode);
    }

    // Space O(n) and Time O(n)
    // space can be decreased by modifying of current list nodes rather than returning of new one
    public static ListNode merge2LL(ListNode l1, ListNode l2) {
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
