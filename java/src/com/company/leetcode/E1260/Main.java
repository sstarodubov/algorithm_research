package com.company.leetcode.E1260;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution().shiftGrid(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 1);
        System.out.println("tests passed");
    }
}


class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            shift(grid);
        }
        var ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < grid.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < grid[0].length; j++) {
                ans.get(i).add(grid[i][j]);
            }
        }
        return ans;
    }

    private void shift(int[][] grid) {
        int prev = 0, cur = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) {
                    prev = grid[row][col];
                    continue;
                }
                cur = grid[row][col];
                grid[row][col] = prev;
                prev = cur;
            }
        }

        grid[0][0] = prev;
    }
}