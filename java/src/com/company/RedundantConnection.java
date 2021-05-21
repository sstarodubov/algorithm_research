package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 */
public class RedundantConnection {
    public static void main(String[] args) {

        var r = new RedundantConnection();

        assert Arrays.equals(new int[]{1, 4}, r.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})) : 0;
        assert Arrays.equals(new int[]{2, 3}, r.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})) : 1;

        System.out.println("tests passed");
    }


    public int[] findRedundantConnection(int[][] edges) {
        var mapper = new HashMap<Integer, Integer>();
        int i = 0;
        for (var edge : edges) {
            if (!mapper.containsKey(edge[0])) {
                mapper.put(edge[0], i);
                i++;
            }

            if (!mapper.containsKey(edge[1])) {
                mapper.put(edge[1], i);
                i++;
            }
        }
        var ans = new ArrayList<Integer>();
        var unionFind = new UnionFinder(mapper);
        for (var edge : edges) {
            int group2 = unionFind.find(edge[0]);
            int group1 = unionFind.find(edge[1]);
            if (group1 == group2) {
                ans.add(edge[0]);
                ans.add(edge[1]);
            } else unionFind.union(edge[0], edge[1]);
        }

        int[] ar = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            ar[j] = ans.get(j);
        }
        return ar;
    }

    class UnionFinder {
        private Map<Integer, Integer> mapper;
        private int[] groups;
        private int[] groupSize;

        public UnionFinder(Map<Integer, Integer> mapper) {
            this.mapper = mapper;
            groups = new int[mapper.size()];
            groupSize = new int[mapper.size()];
            for (int i = 0; i < mapper.size(); i++) {
                groups[i] = i;
                groupSize[i]= 1;
            }
        }

        public int find(int el) {
            Integer idxEl = mapper.get(el);
            if (idxEl == null) throw new IllegalArgumentException();
            while (idxEl != groups[idxEl]) {
                idxEl = groups[idxEl];
            }
            return idxEl;
        }

        public void union(int el1, int el2) {
            int root1 = find(el1);
            int root2 = find(el2);

            if (root1 == root2) return;

            if (groupSize[root1] >= groupSize[root2]) {
                groupSize[root1] += groupSize[root2];
                groups[root2] = root1;
            } else {
                groupSize[root2] += groupSize[root1];
                groups[root1] = root2;
            }
        }
    }
}
