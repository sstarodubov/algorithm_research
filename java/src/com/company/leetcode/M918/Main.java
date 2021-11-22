package com.company.leetcode.M918;

public class Main {
    public static void main(String[] args) {
        assert 19 == new Solution().maxSubarraySumCircular(new int[]{2, -2, 2, 7, 8, 0});
        assert 10 == new Solution().maxSubarraySumCircular(new int[]{5, -3, 5});
        System.out.println("tests passed");
    }
}

class Solution {

    // Time O(n^2) and space O(1)
    public int maxSubarraySumCircular(int[] nums) {
        int ans  = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum = idxSum(nums, i);
            ans = Math.max(curSum, ans);
        }
        return ans;
    }

    public int idxSum(int[] nums, int idx) {
        int sum = nums[idx];
        int ans = nums[idx];
        int curIdx = idx + 1;
        while (true) {
            if (curIdx >= nums.length) {
                curIdx = 0;
            }
            if (idx == curIdx) break;
            if (sum < 0 && nums[curIdx] >= 0) {
                sum = nums[curIdx];
            } else {
                sum += nums[curIdx];
            }

            ans = Math.max(nums[curIdx], Math.max(ans, sum));
            curIdx++;
        }
        return ans;
    }
}
