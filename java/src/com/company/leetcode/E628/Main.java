package com.company.leetcode.E628;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert -6 == new Solution().maximumProduct(new int[]{-1, -2, -3});
        assert 24 == new Solution().maximumProduct(new int[]{1, 2, 3, 4});
        System.out.println("tests passed");
    }
}


class Solution {
    // time O(n * log n) , space O(1)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(
                nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}