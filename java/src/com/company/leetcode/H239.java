package com.company.leetcode;

import java.util.*;

public class H239 {
    public static void main(String[] args) {
        assert Arrays.equals(new Solution().maxSlidingWindow(new int[]{1, 3, -1, 3, 5}, 3), new int[]{3, 3, 5});
        assert Arrays.equals(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), new int[]{3, 3, 5, 5, 6, 7});
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n * log n) and space O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new ArrayList<Integer>(nums.length * 2);
        var tree = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (tree.containsKey(nums[i])) tree.compute(nums[i], (key, val) -> val + 1);
            else tree.put(nums[i], 1);
        }

        int right = k - 1;
        int left = 0;
        while (right < nums.length) {
            int max = tree.firstKey();
            result.add(max);
            tree.compute(nums[left], (key, v) -> v - 1);
            if (tree.get(nums[left]) == 0) tree.remove(nums[left]);
            left++;
            right++;
            if (right >= nums.length) break;
            if (tree.containsKey(nums[right])) tree.compute(nums[right], (key, val) -> val + 1);
            else tree.put(nums[right], 1);
        }

        var ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}