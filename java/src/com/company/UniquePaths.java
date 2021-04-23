package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UniquePaths {
    public static void main(String[] args) {
        var up = new UniquePaths();
        assert 28 == up.uniquePaths(3, 7) : 1;
        assert 3 == up.uniquePaths(3, 2) : 2;
        assert 28 == up.uniquePaths(7, 3) : 3;
        int r = up.uniquePaths(3, 3);
        assert 6 == r : 4;
        assert  193536720 == up.uniquePaths(23, 12) : 5;

        System.out.println("tests passed");
    }

    public int uniquePaths(int m, int n) {
        var memo = new HashMap<Key, Integer>();
        return uniquePathsHelper(m, n, memo);
    }

    public int uniquePathsHelper(int m, int n, Map<Key, Integer> memo) {
        if (m == 1 && n == 1) return 1;
        if (m <= 0 || n <= 0) return 0;
        var k = new Key(m, n);
        if (memo.containsKey(k)) return memo.get(k);
        int up = uniquePathsHelper(m - 1, n, memo) ;
        int left = uniquePathsHelper(m, n - 1, memo);
        memo.put(new Key(m - 1, n), up);
        memo.put(new Key(m, n - 1), left);
        return up + left;
    }

    private static class Key {
        public int m;
        public int n;


        public Key(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return m == key.m && n == key.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, n);
        }
    }
}
