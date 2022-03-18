package com.company.leetcode.E1005;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        assert new Solution().largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3) == 11;
        assert new Solution().largestSumAfterKNegations(new int[]{4, 2, 3}, 1) == 5;
        assert new Solution().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3) == 6;
        assert new Solution().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2) == 13;
        System.out.println("tests passed");
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int t = 0;

        while (t < nums.length && nums[t] < 0 && t < k) {
            nums[t] = -nums[t];
            t++;
        }

        while (t < k) {
            nums[0] = -nums[0];
            t++;
        }

        int ans = 0;
        for (var n : nums) {
            ans += n;
        }
        return ans;
    }
}
