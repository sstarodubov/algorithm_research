package com.company.leetcode.M1749;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert 8 == new Solution().maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2});
        assert 5 == new Solution().maxAbsoluteSum(new int[]{1, -3, 2, 3, -4});

        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n) and space O(n)
    public int maxAbsoluteSum(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);

        int mxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            mxSum = Math.max(nums[i], mxSum);
        }

        int minSum = nums[0];
        for (int i = 1; i < copy.length; i++) {
            copy[i] = Math.min(copy[i], copy[i] + copy[i - 1]);
            minSum = Math.min(minSum, copy[i]);
        }

        return Math.max(Math.abs(minSum), Math.abs(mxSum));
    }
}