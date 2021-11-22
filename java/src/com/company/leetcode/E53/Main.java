package com.company.leetcode.E53;

public class Main {
    public static void main(String[] args) {
        assert -1 == new Solution().maxSubArray(new int[]{-2, -1});
        assert 6 == new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("tests passed");
    }
}

class Solution {

    //time O(n) and space O(1)
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0 && nums[i] >= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            ans = Math.max(nums[i], Math.max(ans, sum));
        }
        return ans;
    }
}
