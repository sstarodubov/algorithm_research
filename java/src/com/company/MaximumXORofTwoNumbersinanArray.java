package com.company;

/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
 */
public class MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {

        assert 28 == findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}) : 0;

        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public static int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }
}
