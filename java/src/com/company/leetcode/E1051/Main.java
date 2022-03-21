package com.company.leetcode.E1051;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert 3 == new Solution().heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println("tests passed");
    }
}

class Solution {
    public int heightChecker(int[] heights) {
        var cp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(cp);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i]  != cp[i]) {
                ans ++;
            }
        }
        return ans;
    }
}