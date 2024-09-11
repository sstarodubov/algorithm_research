package com.company.neetcode;

public class M11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ret = 0;
        while (l < r) {
            ret = Math.max(ret, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ret;
    }
}
