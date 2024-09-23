package com.company.neetcode;

public class M33 {

    public static void main(String[] args) {
        int r = new M33().search(new int[] {3,5,1}, 1);
        System.out.println(r);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            if (nums[0] == target){
                return 0;
            };

            return -1;
        }

        if (n == 2) {
            if (nums[0] == target) {
                return 0;
            }

            if (nums[1] == target) {
                return 1;
            }

            return -1;
        }

        if (nums[0] < nums[n - 1]) {
            return binarySearch(nums, 0, n - 1, target);
        }

        int p = findMin(nums);
        if (p == -1) {
            return -1;
        }

        int k = binarySearch(nums, 0, p, target);
        if (k != -1) {
            return k;
        }
        return binarySearch(nums, p, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int l, int r, int t) {

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == t) {
                return m;
            }

            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public int findMin(int[] nums) {
        int n = nums.length;

        if (nums[0] > nums[n - 1] && nums[n - 2] > nums[n - 1]) {
            return n - 1;
        }
        int l = 1, r = n - 2;

        while (l <= r) {
            int m = (l + r) / 2;

            int lv = nums[m - 1];
            int mv = nums[m];
            int rv = nums[m + 1];

            if (mv < lv && mv < rv) {
                return m;
            } else if (mv > lv && mv < rv && mv < nums[n - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
