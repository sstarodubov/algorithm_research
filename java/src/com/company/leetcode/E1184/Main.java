package com.company.leetcode.E1184;

public class Main {
    public static void main(String[] args) {
        assert 234 == new Solution().distanceBetweenBusStops(new int[]{6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1, 44, 41, 14, 5, 38, 25, 48},
                22, 0);
        assert 4 == new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3);
        assert 3 == new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2);
        System.out.println("tests passed");
    }
}

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int x = 0, y = 0;

        int ptr = start;

        while (ptr != destination) {
            if (ptr >= distance.length) ptr = 0;
            if (ptr == destination) break;
            x += distance[ptr];
            ptr++;

        }

        ptr = destination;
        while (ptr != start) {
            y += distance[ptr];
            ptr++;
            if (ptr >= distance.length) ptr = 0;
        }

        return Math.min(x, y);
    }
}