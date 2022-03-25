package com.company.leetcode.E1287;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert 6 == new Solution().findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10});
        System.out.println("test passed");
    }
}


class Solution {
    public int findSpecialInteger(int[] arr) {
        int max = Integer.MIN_VALUE;
        int num = 0;
        var m = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (m.containsKey(arr[i])) {
                m.computeIfPresent(arr[i], (k, v) -> v + 1);
            } else m.put(arr[i], 1);


            if (max < m.get(arr[i])) {
                max = m.get(arr[i]);
                num = arr[i];
            }
        }
        return num;
    }
}
