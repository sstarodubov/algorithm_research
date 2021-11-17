package com.company.leetcode.M1004;

public class Main {
    public static void main(String[] args) {
        assert 4 == new Solution().longestOnes(new int[]{0, 0, 0, 1}, 4);
        assert 6 == new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n) and space O(1)
    public int longestOnes(int[] nums, int k) {

        if (k == 0) {
            int sum = 0;
            int cur = 0;
            for (int num : nums) {
                if (num == 1) cur++;
                sum = Math.max(cur, sum);
                if (num == 0) cur = 0;
            }
            return sum;
        }

        int start = 0, ans = 1;
        int zeros = 0;
        if (nums[0] == 0) zeros++;
        int end = 1;
        while (end < nums.length) {
            if (zeros <= k) {
                if (nums[end] == 0) {
                    zeros++;
                    if (zeros == k + 1) continue;
                }
                end++;
            } else {
                ans = Math.max(ans, end - start);
                while (zeros > k) {
                    if (nums[start] == 0) {
                        zeros--;
                    }
                    start++;
                }
                end++;
            }
        }
        return Math.max(ans, end - start);
    }
}
