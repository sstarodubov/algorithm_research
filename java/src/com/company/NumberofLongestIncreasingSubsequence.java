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


        // Base Case
        if (nums.length == 0)
            return 0;

        int n = nums.length;

        // Initialize dp_l array with
        // 1s
        int[] dp_l = new int[n];
        Arrays.fill(dp_l, 1);

        // Initialize dp_c array with
        // 1s
        int[] dp_c = new int[n];
        Arrays.fill(dp_c, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // If current element is
                // smaller
                if (nums[i] <= nums[j])
                    continue;

                if (dp_l[j] + 1 > dp_l[i]) {
                    dp_l[i] = dp_l[j] + 1;
                    dp_c[i] = dp_c[j];
                } else if (dp_l[j] + 1 == dp_l[i])
                    dp_c[i] += dp_c[j];
            }
        }

        // Store the maximum element
        // from dp_l
        int max_length = 0;

        for (int i : dp_l)
            max_length = Math.max(i, max_length);

        // Stores the count of LIS
        int count = 0;

        // Traverse dp_l and dp_c
        // simultaneously
        for (int i = 0; i < n; i++) {

            // Update the count
            if (dp_l[i] == max_length)
                count += dp_c[i];
        }

        // Return the count of LIS
        return count;
    }


}
