package com.company.neetcode;

public class E704 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;

        while (l <= r) {
            m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }


        return -1;
    }
}
