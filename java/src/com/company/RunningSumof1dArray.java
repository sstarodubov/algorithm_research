package com.company;

import java.util.Arrays;

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
 */
public class RunningSumof1dArray {
    public static void main(String[] args) {
        var r = new RunningSumof1dArray();
        assert Arrays.equals(new int[]{1, 3, 6, 10}, r.runningSum(new int[]{1, 2, 3, 4})) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int[] runningSum(int[] nums) {
        if (nums.length == 1) return nums;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}
