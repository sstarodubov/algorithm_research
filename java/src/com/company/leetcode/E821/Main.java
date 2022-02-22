package com.company.leetcode.E821;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        assert Arrays.equals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, new Solution().shortestToChar("loveleetcode", 'e'));

        System.out.println("tests passed");
    }
}

class Solution {
    // time O(n * log (n) ) , space ( c * count )
    public int[] shortestToChar(String s, char c) {
        var tree = new TreeSet<Integer>();
        var arr = new int[s.length()];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                tree.add(i);
                arr[i] = 0;
            }
        }
        for (int i = 0; i < s.length(); i++) { // O(n)
            if (s.charAt(i) == c) continue;
            var floor = tree.floor(i); // O (log (n))
            var cell = tree.ceiling(i); // O (log (n))
            if (floor == null) floor = Integer.MAX_VALUE;
            if (cell == null) cell = Integer.MAX_VALUE;
            var diff1 = Math.abs(floor - i);
            var diff2 = Math.abs(cell - i);
            arr[i] = Math.min(diff1, diff2);
        }

        return arr;
    }
}