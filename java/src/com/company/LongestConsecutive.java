package com.company;

import java.util.Arrays;

public class LongestConsecutive {

    public static void main(String[] args) {
        assert 4 == longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) : 1;
        assert 9 == longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) : 2;
        assert 0 == longestConsecutive(new int[] {}) : 3;
        assert 3 == longestConsecutive(new int[] {1,2,0,1}): 4;
        System.out.println("tests passed");
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int out = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) out++;
            else if (nums[i] != nums[i -1]) {
                res = Math.max(out, res);
                out = 1;
            }
        }
        return Math.max(res, out);
    }
}
