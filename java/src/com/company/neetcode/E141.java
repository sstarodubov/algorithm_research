package com.company.neetcode;

import com.company.ListNode;

public class E141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (null != fast) {
           slow = slow.next;
           fast = fast.next;

           if (null == fast) {
               return false;
           } else {
               fast = fast.next;
           }

           if (fast == slow) {
               return true;
           }
        }


        return false;
    }
}
