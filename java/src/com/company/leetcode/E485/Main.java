package com.company.leetcode.E485;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n) and space O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
        }
        return ans;
    }
}
