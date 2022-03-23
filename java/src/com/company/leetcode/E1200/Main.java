package com.company.leetcode.E1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            diff = Math.min(diff, arr[i] - arr[i - 1]);
        }
        var ans = new ArrayList<List<Integer>>();

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i] - arr[i - 1];
            if (cur == diff) {
                ans.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}