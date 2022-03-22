package com.company.leetcode.E1128;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        assert 11 == new Solution().numEquivDominoPairs(new int[][]{{2, 1}, {5, 4}, {3, 7}, {6, 2}, {4, 4}, {1, 8}, {9, 6}, {
                5, 3}, {7, 4}, {1, 9}, {1, 1}, {6, 6}, {9, 6}, {1, 3}, {9, 7}, {4, 7}, {5, 1}, {6, 5}, {1, 6}, {6, 1}, {1, 8}, {7, 2}, {2, 4}, {
                1, 6}, {3, 1}, {3, 9}, {3, 7}, {9, 1}, {1, 9}, {8, 9}});
        assert 1 == new Solution().numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}});
        assert 3 == new Solution().numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}});
        System.out.println("tests passed");
    }
}

class Pair  {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x) + Objects.hashCode(y);
    }

    @Override
    public boolean equals(Object obj) {
        var cur = (Pair) obj;
        return this.x == cur.x && this.y == cur.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Solution {
    // time O(n log n ) , space O(n)
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            dominoes[i][0] = a;
            dominoes[i][1] = b;
        }
        Arrays.sort(dominoes, Comparator.comparingInt((int[] xs) -> xs[0]).thenComparingInt(xs -> xs[1]));


        var map = new HashMap<Pair, Integer>();
        for (int i = 0; i < dominoes.length; i++) {
            var key = new Pair(dominoes[i][0] , dominoes[i][1]);
            int val = map.getOrDefault(key, 0);
            map.put(key, val + 1);
        }
        int ans = 0;
        for (var entry : map.entrySet()) {
            int n = entry.getValue();
            if (n != 1) {
                ans += (n * (n - 1)) / 2;
            }
        }
        if (ans == 0) return 1;
        return ans;
    }
}