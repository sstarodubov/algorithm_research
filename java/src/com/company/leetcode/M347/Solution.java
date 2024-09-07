package com.company.leetcode.M347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    record Pair(int key, int val) { }
    public int[] topKFrequent(int[] nums, int k) {
        var hm = new HashMap<Integer, Integer>();

        for (int n : nums) {
            int t = hm.getOrDefault(n, 0);
            hm.put(n, t + 1);
        }

        int[] ret = new int[k];

        var pq = new PriorityQueue<Pair>(hm.size(), (o1, o2) -> o2.val() - o1.val());

        for (var ks : hm.keySet()) {
            pq.add(new Pair(ks, hm.get(ks)));
        }

        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll().key();
        }

        return ret;
    }
}
