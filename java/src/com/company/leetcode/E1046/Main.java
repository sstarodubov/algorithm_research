package com.company.leetcode.E1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        assert 1 == new Solution().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        assert 1 == new Solution().lastStoneWeight(new int[]{1});
        System.out.println("tests passed");
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var stone : stones) {
            heap.add(stone);
        }

        while (true) {
            if (heap.isEmpty()) return 0;
            if (heap.size() == 1) return heap.poll();

            int j = heap.poll();
            int c = heap.poll();
            if (j != c) {
                heap.add(j - c);
            }
        }
    }
}