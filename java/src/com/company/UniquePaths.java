package com.company;

public class UniquePaths {
    public static void main(String[] args) {
        var up = new UniquePaths();
//        assert 28 == up.uniquePaths(3, 7) : 1;
//        assert 3 == up.uniquePaths(3, 2) : 2;
//        assert 28 == up.uniquePaths(7, 3) : 3;
//        int r = up.uniquePaths(3, 3);
//        assert 6 == r : 4;
//        assert 193536720 == up.uniquePaths(23, 12) : 5;
        assert 2 == up.uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}}
        );
        System.out.println("tests passed");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        var memo = new int [obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstaclesHelper(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid, memo);
    }


    public int uniquePathsWithObstaclesHelper(int m, int n, int[][] grid, int[][] memo) {
        if (m < 0 || n < 0) return 0;
        if (grid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (memo[m][n] != 0) return memo[m][n];
        int up = uniquePathsWithObstaclesHelper(m - 1, n,  grid, memo);
        int left = uniquePathsWithObstaclesHelper(m, n - 1, grid, memo);
        memo[m][n] = up + left;
        return memo[m][n];
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
