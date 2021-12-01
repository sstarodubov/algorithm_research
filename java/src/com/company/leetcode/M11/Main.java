package com.company.leetcode.M11;

public class Main {
    public static void main(String[] args) {
        assert new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49;
        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n ^2)
    public int maxArea(int[] height) {
        int max = 0;
        for (int start = 0; start < height.length; start++) {
            for (int end = start + 1; end < height.length; end++) {
                max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            }
        }
        return max;
    }
}
