package com.company.leetcode;

import java.util.*;

public class H239 {
    public static void main(String[] args) {
        assert Arrays.equals(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3), new int[]{3, 3, 5, 5, 6, 7});
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n ^2) and space O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new ArrayList<Integer>(nums.length * 2);
        var pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        int right = k - 1;
        int left = 0;
        while (right < nums.length) {
            int max = pq.element();
            result.add(max);
            pq.remove(nums[left]);
            left++;
            right++;
            if (right >= nums.length) break;
            pq.add(nums[right]);
        }

        var ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}