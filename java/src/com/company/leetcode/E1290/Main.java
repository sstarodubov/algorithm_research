package com.company.leetcode.E1290;

import com.company.ListNode;

public class Main {
    public static void main(String[] args) {
        assert 5 == new Solution().getDecimalValue(ListNode.buildLinkedList(new int[]{1, 0, 1}));
        System.out.println("tests passed");
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        var cur = head;
        int ans = 0;
        while (true) {
            ans = ans | cur.val;
            cur = cur.next;
            if (cur == null) break;
            ans = ans << 1;
        }

        return ans;
    }
}
