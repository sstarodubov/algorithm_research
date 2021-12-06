package com.company.leetcode.M18;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}

class Solution {

    // cpu O(n ^3) and space O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length <= 2) return Collections.emptyList();
        Arrays.sort(nums);
        var ans = new ArrayList<List<Integer>>();
        var used = new HashSet<String>();
        int[] pair = new int[]{0, 0};
        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                String key = "";
                if (nums[first] < nums[second]) key = nums[first] + ";" + nums[second];
                else key = nums[second] + ";" + nums[first];
                var goal = target - (nums[second] + nums[first]);
                if (!used.contains(key)) {
                    pair[0] = nums[first];
                    pair[1] = nums[second];
                    twoSum(nums, second, goal, ans, pair);
                }
                used.add(key);
            }
        }
        return ans;
    }

    public void twoSum(int[] nums, int startIdx, int target, List<List<Integer>> ans, int[] pair) {
        int l = startIdx + 1;
        int r = nums.length - 1;
        int lastL = Integer.MAX_VALUE;
        int lastR = Integer.MAX_VALUE;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                ans.add(new ArrayList<>(List.of(nums[l], nums[r], pair[0], pair[1])));
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