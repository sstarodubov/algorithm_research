package com.company.leetcode.M238;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] ints = new Solution().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        var l = new int[n + 2];
        var r = new int[n + 2];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);

        for (int i = 0; i < n; i++) {
           l[i+1] = nums[i] * l[i];
        }

        for(int i = n - 1; i >=0; i--) {
           r[i + 1] =  nums[i] * r[i + 2];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = l[i] * r[i + 2];
        }
        return nums;
    }
}
