package com.company.leetcode.E1207;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        assert new Solution().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        System.out.println("tests passed");
    }
}

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        var set = new HashSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        for (var n : arr) {
            if (map.containsKey(n)) map.computeIfPresent(n, (k, v) -> v + 1);
            else map.put(n, 1);
        }

        for (var entry : map.entrySet()) {
            if (set.contains(entry.getValue())) return false;
            set.add(entry.getValue());
        }
        return true;
    }
}