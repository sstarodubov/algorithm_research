package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        var m = new CourseSchedule();
        assert m.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}) : -10;
        m.flag = false;
        assert m.canFinish(2, new int[][]{{1, 0}}) : 1;
        m.flag = false;
        assert !m.canFinish(2, new int[][]{{1, 0}, {0, 1}}) : 2;
        System.out.println("tests passed");
    }

    boolean flag = false;

    // Time O(n) and Space O(n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, List<Integer>>();
        for (var edge : prerequisites) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());
        }
        for (var edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>(); // 0 - white // 1 - gray // 2 - black
        for (var entry : graph.entrySet()) {
            visited.put(entry.getKey(), false);
            color.put(entry.getKey(), 0);
        }

        for (var node : graph.entrySet()) {
            if (!visited.get(node.getKey())) {
                dfs(graph, color, visited, node.getKey());
                if (flag) return false;
            }
        }
        return true;
    }

    public void dfs(Map<Integer, List<Integer>> graph, Map<Integer, Integer> color, Map<Integer, Boolean> visited, int node) {
        if (color.get(node) == 1) {
            flag = true;
            return;
        }
        if (visited.get(node)) return;
        visited.put(node, true);
        color.put(node, 1);
        var children = graph.get(node);
        for (int child : children) {
            dfs(graph, color, visited, child);
        }
        color.put(node, 2);
    }
}
