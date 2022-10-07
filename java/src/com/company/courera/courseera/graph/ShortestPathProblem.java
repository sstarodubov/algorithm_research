package graph;

import java.util.ArrayList;
import java.util.List;

record DirectedEdge(int v, int w, double weigth) {
    public int from() {
        return v;
    }

    public int to() {
        return w;
    }
}

class EdgeWeightedDirectedGraph {
    private final int V;
    private final List<List<DirectedEdge>> adj;
    private final List<DirectedEdge> edges = new ArrayList<>();

    public EdgeWeightedDirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(DirectedEdge e) {
        int v = e.from();
        adj.get(v).add(e);
        edges.add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }

    public Iterable<DirectedEdge> edges() {
        return edges;
    }
}

public class ShortestPathProblem {
    public static void main(String[] args) {

    }
}
