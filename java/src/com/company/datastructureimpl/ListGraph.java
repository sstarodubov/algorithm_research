package com.company.datastructureimpl;

import java.util.*;

public class ListGraph {

    public static void main(String[] args) {
        var n1 = new GraphListNode("A", 0);
        var n2 = new GraphListNode("B", 1);
        var n3 = new GraphListNode("C", 2);
        var n4 = new GraphListNode("D", 3);
        var n5 = new GraphListNode("H", 4);

        var graph = new ListGraph(List.of(n1, n2, n3, n4, n5, new GraphListNode("E", 5)));
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 4);

        graph.bfs();
    }

    public final List<GraphListNode> nodes;

    public ListGraph(List<GraphListNode> nodes) {
        this.nodes = nodes;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphListNode first = nodes.get(i);
        GraphListNode second = nodes.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public void bfs() {
        var visited = new HashSet<GraphListNode>();
        var dq = new ArrayDeque<GraphListNode>();
        for (var node : nodes) {
            dq.add(node);
            while (!dq.isEmpty()) {
                var cur = dq.pollFirst();
                if (visited.contains(cur)) continue;
                visited.add(cur);

                System.out.println(cur.name);
                dq.addAll(cur.neighbors);
            }
        }
    }

    public void dfs() {
        var set = new HashSet<GraphListNode>();
        for (GraphListNode node : nodes) {
            if (!set.contains(node)) {
                dfs(node, set);
            }
        }
    }

    private void dfs(GraphListNode node, Set<GraphListNode> visited) {
        if (node == null) return;
        if (visited.contains(node)) return;
        // handle node ===
        System.out.println(node.name);
        // ========
        visited.add(node);
        var children = node.neighbors;
        for (var child : children) {
            dfs(child, visited);
        }
    }
}


class GraphListNode {
    public final String name;
    public final int idx;
    public final List<GraphListNode> neighbors = new ArrayList<>();

    public GraphListNode(String name, int idx) {
        this.idx = idx;
        this.name = name;
    }
}
