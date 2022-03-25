package com.company.leetcode.E1295;

class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((digit(nums[i]) & 1) == 0) ans++;
        }
        return ans;
    }

    public int digit(int n) {
        int ctr = 0;
        while (n > 0) {
            n /= 10;
            ctr++;
        }

        return ctr;
    }
}