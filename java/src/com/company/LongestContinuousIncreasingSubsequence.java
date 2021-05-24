package com.company;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        var l = new LongestContinuousIncreasingSubsequence();

        assert 4 == l.findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}) : -1;
        assert 3 == l.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}) : 0;
        assert 1 == l.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2, 2}) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] lens = new int[nums.length];
        Arrays.fill(lens, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) lens[i] = lens[i - 1] + 1;
            else lens[i] = 1;
            max = Math.max(max, lens[i]);
        }
        return max;
    }
}
