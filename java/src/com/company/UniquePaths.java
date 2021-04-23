package com.company;

public class UniquePaths {
    public static void main(String[] args) {
        var up = new UniquePaths();
        assert 28 == up.uniquePaths(3, 7) : 1;
        assert 3 == up.uniquePaths(3, 2) : 2;
        assert 28 == up.uniquePaths(7, 3) : 3;
        int r = up.uniquePaths(3, 3);
        assert 6 == r : 4;
        assert 193536720 == up.uniquePaths(23, 12) : 5;
        System.out.println("tests passed");
    }

    public int uniquePaths(int m, int n) {
        var memo = new int[m + 1][n + 1];
        return uniquePathsHelper(m, n, memo);
    }

    public int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m == 1 && n == 1) return 1;
        if (m <= 0 || n <= 0) return 0;
        if (memo[m][n] != 0) return memo[m][n];
        int up = uniquePathsHelper(m - 1, n, memo);
        int left = uniquePathsHelper(m, n - 1, memo);
        memo[m][n] = up + left;
        return memo[m][n];
    }
}
