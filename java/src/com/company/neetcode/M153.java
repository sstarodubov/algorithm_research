package com.company.neetcode;

public class M153 {

    public static void main(String[] args) {
        assert 1 == new M153().findMin(new int[]{3, 4, 5, 6, 1, 2});
        assert 1 == new M153().findMin(new int[]{2, 3, 1});
        assert 1 == new M153().findMin(new int[]{3, 4, 5, 1, 2});
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }

        if (nums[0] > nums[n - 1] && nums[n - 2] > nums[n - 1]) {
            return nums[n - 1];
        }
        int l = 1, r = n - 2;

        while (l <= r) {
            int m = (l + r) / 2;

            int lv = nums[m - 1];
            int mv = nums[m];
            int rv = nums[m + 1];

            if (mv < lv && mv < rv) {
                return mv;
            } else if (mv > lv && mv < rv && mv < nums[n - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
