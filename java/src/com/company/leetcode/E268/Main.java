package com.company.leetcode.E268;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        assert 2 == new Solution().missingNumber(new int[]{3, 0, 1});

        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) , space O(n)
    public int missingNumber(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) set.add(num);
        int cur = 0;
        while (cur != nums.length + 1) {
            if (!set.contains(cur)) return cur;
            cur++;
        }
        return 0;
    }
}
