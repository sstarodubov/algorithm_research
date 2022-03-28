package com.company.leetcode.E1299;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        new Solution().replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println("tests passed");
    }
}

class Solution {
    public int[] replaceElements(int[] arr) {
        int cur = -1;
        var ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = cur;
            cur = Math.max(cur, arr[i]);
        }

        return null;
    }
}
