package com.company.leetcode.M283;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var arr2 = new int[]{1, 0, 1};
        new Solution().moveZeroes(arr2);
        assert Arrays.equals(arr2, new int[]{1, 1, 0});
        var arr1 = new int[]{1, 0};
        new Solution().moveZeroes(arr1);
        assert Arrays.equals(new int[]{1, 0}, arr1);
        var arr = new int[]{0, 1, 0, 3, 12};
        new Solution().moveZeroes(arr);
        assert Arrays.equals(new int[]{1, 3, 12, 0, 0}, arr);
        System.out.println("tests passed");
    }
}


class Solution {
    // time O(n) , space O(1)
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int zeroPtr = 0;
        while (zeroPtr < nums.length && nums[zeroPtr] != 0) zeroPtr++;
        int numPtr = zeroPtr;
        while (numPtr < nums.length && nums[numPtr] == 0) numPtr++;

        while (zeroPtr < nums.length && numPtr < nums.length) {

            int tmp = nums[zeroPtr];
            nums[zeroPtr] = nums[numPtr];
            nums[numPtr] = tmp;

            while (zeroPtr < nums.length && nums[zeroPtr] != 0) zeroPtr++;

            while (numPtr < nums.length && nums[numPtr] == 0) numPtr++;

        }
    }
}

