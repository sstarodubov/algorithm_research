package com.company.leetcode.M11;

public class Main {
    public static void main(String[] args) {
        assert new Solution().maxArea(new int[]{1, 2, 1}) == 2;
        assert new Solution().maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}) == 24;
        assert new Solution().maxArea(new int[]{4, 3, 2, 1, 4}) == 16;
        assert new Solution().maxArea(new int[]{1, 1}) == 1;
        assert new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49;
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n) , space O(1)
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = Math.min(height[l], height[r]) * (r - l);

        while (l < r) {
            if (height[l] > height[r]) r--;
            else if (height[r] > height[l]) l++;
            else {
                r--;
                l++;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }
}
