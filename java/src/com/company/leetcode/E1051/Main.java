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
        // counting sort

        int[] counter = new int[101];

        for (int height : heights) {
            counter[height] += 1;
        }

        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        var sorted = new int[heights.length];

        for (int h : heights) {
            int idx = counter[h];
            counter[h]--;
            sorted[idx - 1] = h;
        }
        // wraping up
        int ans = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != heights[i]) ans++;
        }

        return ans;
    }
}