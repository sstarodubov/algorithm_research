package com.company;

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 */
public class NumberofProvinces {

    public static void main(String[] args) {

        var n = new NumberofProvinces();
        assert 2 == n.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}) : 1;
        assert 3 == n.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}) : 2;
        System.out.println("tests passed");
    }

    public int findCircleNum(int[][] isConnected) {
        int[] v = new int[isConnected.length];
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (v[i] == 0) {
                helper(isConnected, i, v);
                ans++;
            }
        }
        return ans;
    }

    public void helper(int[][] graph, int cur, int[] v) {
        v[cur] = 1;
        int[] map = graph[cur];
        for (int node = 0; node < map.length; node++) {
            if (v[node] == 1) continue;
            if (node == cur) continue;
            if (map[node] == 1) {
                helper(graph, node, v);
            }
        }
    }
}
