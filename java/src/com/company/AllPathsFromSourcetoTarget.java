package com.company;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    public static void main(String[] args) {
        var a = new AllPathsFromSourcetoTarget();

        List<List<Integer>> res = a.allPathsSourceTarget(new int[][]{
                new int[]{1, 2},
                new int[]{3},
                new int[]{3},
                new int[]{}
        });
        assert res.size() == 2;

        var r2 = a.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        assert r2.size() == 5;

        System.out.println("tests passed");
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(graph, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[][] graph, int cur, List<Integer> tmp, List<List<Integer>> ans) {
        tmp.add(cur);

        if (cur == graph.length - 1) {
            ans.add(List.copyOf(tmp));
            return;
        }

        int[] children = graph[cur];

        for (int child : children) {
            helper(graph, child, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }

    }
}
