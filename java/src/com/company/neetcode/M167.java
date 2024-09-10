package com.company.neetcode;

public class M167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, m;
        while (l < r) {
            m = numbers[l] + numbers[r];
            if (m == target) {
                return new int[]{l + 1, r + 1};
            }

            if (m > target) {
               r--;
            } else {
               l++;
            }
        }

        return new int[]{-1, -1};
    }
}
