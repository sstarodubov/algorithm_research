package com.company.datastructureimpl;

import java.util.List;

public class MatrixGraph {
    public final List<GraphNode> nodes;
    public final int[][] matrix;

    public MatrixGraph(List<GraphNode> nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes.size()][nodes.size()];
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
