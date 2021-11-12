package com.company.leetcode.E219;

import java.util.HashSet;

public class E219 {
    public static void main(String[] args) {
        assert !new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
        assert new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        System.out.println("tests passed");
    }
}


class Solution {

    // cpu O(n) and space O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        var set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                int last = nums[i - k - 1];
                set.remove(last);
            }
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}