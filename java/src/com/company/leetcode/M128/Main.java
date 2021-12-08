package com.company.leetcode.M128;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().longestConsecutive(new int[]{1, 2, 0, 1});
        assert 4 == new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        assert 9 == new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n log n), space O(1)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int ans = 0;
        int curLen = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) continue;
            if (cur == nums[i] - 1) {
                curLen++;
            } else {
                ans = Math.max(ans, curLen);
                curLen = 1;
            }
            cur = nums[i];
        }
        return Math.max(curLen, ans);
    }
}
