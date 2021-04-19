package com.company;

import java.util.HashMap;

public class DataStructures {
    public static void main(String[] args) {
        var arr = new int[]{10, 9, 4, 5, 2, 4, 12};
        assert hasPair(arr) : "hasPair(arr)";
        assert 3 == findSubarray(arr): "findSubarray";
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public static boolean hasPair(int[] xs) {
        var map = new HashMap<Integer, Boolean>();
        for (int x : xs) {
            if (map.containsKey(x)) return true;
            else map.put(x, true);
        }
        return false;
    }

    // Time O(n) and Space O(1)
    public static int findSubarray(int[] xs) {
        int r = 0;
        int out = 0;
        boolean isSub = false;
        for (int i = 1; i < xs.length - 1 ; i++) {
            if (xs[i+1] >= xs[i]) {
                isSub = true;
            } else isSub = false;
            if (isSub) out ++;
            else r = Math.max(r, out);
        }

        return Math.max(r, out);
    }
}
