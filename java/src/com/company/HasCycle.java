package com.company;

import java.util.HashMap;

public class HasCycle {

    public static void main(String[] args) {
        var head = new ListNode(3);
        var n2 = new ListNode(2);
        var n0 = new ListNode(0);
        var n4 = new ListNode(-4);
        head.next = n2;
        n2.next = n0;
        n0.next = n4;
        n4.next = n2;

        assert hasCycle(head) : 1;

        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public static boolean hasCycle(ListNode head) {
        var table = new HashMap<ListNode, Boolean>();
        var cur = head;
        while (cur != null) {
            if (table.containsKey(cur)) return true;
            table.put(cur, true);
            cur = cur.next;
        }
        return false;
    }
}
