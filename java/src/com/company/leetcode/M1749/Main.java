package com.company.leetcode.M1749;

public class Main {
    public static void main(String[] args) {
        assert 8 == new Solution().maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2});
        assert 5 == new Solution().maxAbsoluteSum(new int[]{1, -3, 2, 3, -4});

        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n) and space O(1)
    public int maxAbsoluteSum(int[] nums) {

        int mxSum = nums[0];
        int minPrev = nums[0];
        int maxPrev = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + maxPrev);
            mxSum = Math.max(curMax, mxSum);

            curMin = Math.min(nums[i], nums[i] + minPrev);
            minSum = Math.min(minSum, curMin);

            maxPrev = curMax;
            minPrev = curMin;
        }

        return Math.max(Math.abs(minSum), Math.abs(mxSum));
    }
}