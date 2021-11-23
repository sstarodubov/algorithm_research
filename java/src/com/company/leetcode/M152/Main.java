package com.company.leetcode.M152;

public class Main {
    public static void main(String[] args) {
        assert 60 == new Solution().maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2});
        assert 24 == new Solution().maxProduct(new int[]{2, -5, -2, -4, 3});
        assert 6 == new Solution().maxProduct(new int[]{2, 3, -2, 4});
        assert 0 == new Solution().maxProduct(new int[]{-2, 0, -1});
        System.out.println("tests passed");
    }
}

class Solution {

    // time O(n) and space O(1)
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prevSum = nums[0];
        int bestSum = nums[0];
        int worstSum = nums[0];
        int curSum = nums[0];
        int allSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, Math.max(bestSum, Math.max(curSum, Math.max(worstSum, prevSum))));
            int tmp = bestSum;
            bestSum = Math.max(nums[i] * curSum, Math.max(nums[i] * prevSum, Math.max(nums[i] * bestSum, nums[i] * worstSum)));
            worstSum = Math.min(nums[i] * curSum, Math.min(nums[i] * prevSum, Math.min(nums[i] * tmp, nums[i] * worstSum)));
            curSum = nums[i];
            prevSum = nums[i - 1] * nums[i];

            allSum *= nums[i];
        }

        ans = Math.max(ans, Math.max(bestSum, Math.max(curSum, Math.max(worstSum, prevSum))));
        return Math.max(ans, allSum);
    }
}
