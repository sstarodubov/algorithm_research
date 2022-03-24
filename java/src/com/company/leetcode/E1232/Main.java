package com.company.leetcode.E1232;

public class Main {
    public static void main(String[] args) {
        assert new Solution().checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}});
        assert new Solution().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}});
        System.out.println("tests passed");
    }
}


class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1)) return false;
        }
        return true;
    }
}