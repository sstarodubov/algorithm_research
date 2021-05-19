package com.company;


/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words,
 any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
indicates that there is an undirected edge between the two nodes ai and bi in the tree,
you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h.
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        var m = new MinimumHeightTrees();

        List<Integer> minHeightTrees = m.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        assert minHeightTrees.get(0) == 3;
        assert minHeightTrees.get(1) == 4;

        System.out.println("tests passed");
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] degree = new int[n];
        var leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();
            if (degree[i] == 0 || degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }
        int count = leaves.size();
        while (count < n) {
            var newLeaves = new ArrayList<Integer>();
            for (int leave : leaves) {
                for (var neighbor : graph.get(leave)) {
                    degree[neighbor] = degree[neighbor] - 1;
                    if (degree[neighbor] == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

}
