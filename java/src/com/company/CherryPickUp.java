package com.company;

import java.util.Arrays;

/*
You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.

    0 means the cell is empty, so you can pass through,
    1 means the cell contains a cherry that you can pick up and pass through, or
    -1 means the cell contains a thorn that blocks your way.

Return the maximum number of cherries you can collect by following the rules below:

    Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
    After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
    When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
    If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.

 */
public class CherryPickUp {
    public static void main(String[] args) {
        var m = new CherryPickUp();

        assert 5 == m.cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        }) : 0;
        System.out.println("tests passed");
    }

    private int ans = 0;

    public int cherryPickup(int[][] grid) {
        var paths = buildPaths(grid);
        goDown(grid, paths);
        pickupCherry(grid, paths);
        var arr = buildPaths(grid);
        goDown(grid, arr);
        pickupCherry(grid, arr);
        return ans;
    }

    public int[][] buildPaths(int[][] grid) {
        var paths = new int[grid.length][grid.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = Arrays.copyOf(grid[i], paths.length);
        }
        return paths;
    }

    public void goDown(int[][] grid, int[][] paths) {
        for (int i = 1; i < paths.length; i++) {
            if (grid[i][0] != -1) paths[i][0] += grid[i - 1][0];
            if (grid[0][i] != -1) paths[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (paths[i][j] == -1) continue;
                int above = paths[i - 1][j];
                int left = paths[i][j - 1];
                paths[i][j] = Math.max(above, left) + paths[i][j];
            }
        }
    }

    public void pickupCherry(int[][] grid, int[][] paths) {
        int r = grid.length - 1;
        int c = grid.length - 1;
        while (r > 0 && c > 0) {
            if (grid[c][r] == 1) {
                ans++;
                grid[c][r] = 0;
            }
            if (grid[c][r - 1] == -1 && grid[c - 1][r] == -1) {
                ans = 0;
                return;
            }
            else if (grid[c][r - 1] != -1 && grid[c - 1][r] == -1) r--;
            else if (grid[c - 1][r] != -1 && grid[c][r - 1] == -1) c--;
            else {
                int left = paths[c][r - 1];
                int above = paths[c - 1][r];
                if (left >= above) r--;
                else c--;
            }
        }

        if (c == 0) {
            while (r >= 0) {
                if (grid[c][r] == -1) return;
                if (grid[c][r] == 1) {
                    ans++;
                    grid[c][r] = 0;
                } else r--;
            }
        } else {
            while (c >= 0) {
                if (grid[c][r] == -1) return;
                if (grid[c][r] == 1) {
                    ans++;
                    grid[c][r] = 0;
                } else c--;
            }
        }
    }
}
