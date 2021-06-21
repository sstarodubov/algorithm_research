package com.company;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

        assert isPalindrome(ListNode.buildLinkedList(new int[]{1, 2, 2, 1})) : 0;
        assert !isPalindrome(ListNode.buildLinkedList(new int[]{1, 2})) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public static boolean isPalindrome(ListNode head) {
        ListNode h = head;
        int len = 1;
        while (h != null) {
            h = h.next;
            if (h == null) break;
            len++;
        }
        int rL = len % 2 == 0 ? (len / 2) + 1 : (len / 2) + 2;
        var dummyHead = new ListNode();

        h = head;
        int p = 1;
        while (h != null) {
            if (p == rL) {
                dummyHead.next = h;
                break;
            }
            h = h.next;
            p++;
        }

        ListNode cur = dummyHead.next;
        dummyHead.next = null;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = tmp;
        }
        ListNode rh = dummyHead.next;

        for (int i = 0; i < len / 2; i++) {
            if (rh.val == head.val) {
                rh = rh.next;
                head = head.next;
            } else return false;
        }
        return true;
    }
}
