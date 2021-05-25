package com.company;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
    public static void main(String[] args) {

        var n = new NumberofLongestIncreasingSubsequence();
        assert 3 == n.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        assert 2 == n.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}) : 1;
        assert 1 == n.findNumberOfLIS(new int[]{3, 1, 2}) : -1;
        assert 5 == n.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}) : 0;

        System.out.println("tests passed");
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int[] lens = new int[n];
        Arrays.fill(lens, 1);
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j])
                    continue;
                if (lens[j] + 1 > lens[i]) {
                    lens[i] = lens[j] + 1;
                    counts[i] = counts[j];
                } else if (lens[j] + 1 == lens[i])
                    counts[i] += counts[j];
            }
        }

        int maxLength = 0;
        for (int i : lens) {
            maxLength = Math.max(i, maxLength);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (lens[i] == maxLength)
                count += counts[i];
        }

        return count;
    }
}
