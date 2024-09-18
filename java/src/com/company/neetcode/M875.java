package com.company.neetcode;

import java.util.Arrays;

public class M875 {

    public static void main(String[] args) {
        System.out.println(new M875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (var p : piles) {
            max = Math.max(max, p);
        }

        int l = 1, r = max;
        int ret = r;
        while (l <= r) {
            int k = (l + r) / 2;

            int total = 0;

            for (var p : piles) {
                total += Math.ceil(((double) p) / k);
            }

            if (total <= h) {
                ret = k;
                r = k - 1;
            } else {
                l = k + 1;
            }

        }

        return ret;
    }
}
