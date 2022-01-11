package com.company.datastructureimpl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatrixGraph {

    public static void main(String[] args) {
        var n1 = new GraphNode("A", 0);
        var n2 = new GraphNode("B", 1);
        var n3 = new GraphNode("C", 2);
        var n4 = new GraphNode("D", 3);
        var n5 = new GraphNode("H", 4);
        var graph = new MatrixGraph(List.of(n1, n2, n3, n4, n5, new GraphNode("E", 5)));

        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(2, 4);

        graph.dfs();
    }

    public final List<GraphNode> nodes;
    public final int[][] matrix;

    public MatrixGraph(List<GraphNode> nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes.size()][nodes.size()];
    }

    public List<GraphNode> getNeighbors(GraphNode node) {
        var list = new ArrayList<GraphNode>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node.idx][i] == 1) {
                list.add(nodes.get(i));
            }
        }
        return list;
    }

    public void dfs() {
        var stack = new ArrayDeque<GraphNode>();
        var visit = new HashSet<GraphNode>();
        for (var n : nodes) {
            stack.push(n);
            while (!stack.isEmpty()) {
                var cur = stack.pop();
                if (visit.contains(cur)) continue;
                visit.add(cur);
                System.out.print(cur.name);
                var neighbors = getNeighbors(cur);
                for (var neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public void bfs() {
        var dq = new ArrayDeque<GraphNode>();
        var visited = new HashSet<GraphNode>();

        for (var node : nodes) {
            if (visited.contains(node)) continue;

            dq.add(node);

            while (!dq.isEmpty()) {
                var cur = dq.pollFirst();
                if (visited.contains(cur)) continue;
                System.out.print(cur.name);
                visited.add(cur);
                dq.addAll(getNeighbors(cur));
            }
        }
    }

    public void addUndirectedEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    public void removeUndirectedEdge(int i, int j) {
        matrix[i][j] = 0;
        matrix[j][i] = 0;
    }
}

class GraphNode {
    public String name;
    public int idx;

    public GraphNode(String name, int idx) {
        this.idx = idx;
        this.name = name;
    }
}
