package com.company.leetcode.M15;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var r5 = new Solution().threeSum(new int[]{0, -4, -1, -4, -2, -3, 2});
        var r4 = new Solution().threeSum(new int[]{-2, 0, 0, 2, 2});
        var result3 = new Solution().threeSum(new int[]{0, 0, 0, 0});
        var result2 = new Solution().threeSum(new int[]{0, 0, 0});
        var result = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) return Collections.emptyList();
        var ans = new ArrayList<List<Integer>>();
        var used = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) twoSum(nums, i, -nums[i], ans);
            used.add(nums[i]);
        }
        return ans;
    }

    public void twoSum(int[] nums, int exceptIdx, int target, List<List<Integer>> ans) {
        int l = exceptIdx + 1;
        int r = nums.length - 1;
        int lastL = Integer.MAX_VALUE;
        int lastR = Integer.MAX_VALUE;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                ans.add(new ArrayList<>(List.of(nums[l], nums[r], -target)));
                l++;
                r--;
                lastL = nums[l - 1];
                lastR = nums[r + 1];
            } else if (nums[l] + nums[r] < target) {
                l++;
                lastL = nums[l - 1];
            } else {
                r--;
                lastR = nums[r + 1];
            }
            while (l < nums.length && nums[l] == lastL) l++;
            while (r >= 0 && nums[r] == lastR) r--;

        }
    }
}
