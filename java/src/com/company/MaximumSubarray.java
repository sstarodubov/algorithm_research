package com.company;

public class MaximumSubarray {
    public static void main(String[] args) {
        var m = new MaximumSubarray();

        assert 6 == m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) Space O(n)
    public int maxSubArray(int[] nums) {
        int[] curMax = new int[nums.length];
        curMax[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax[i] = Math.max(nums[i], curMax[i - 1] + nums[i]);
            max = Math.max(curMax[i], max);
        }
        return max;
    }
}
