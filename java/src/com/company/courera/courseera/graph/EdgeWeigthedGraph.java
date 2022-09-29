package graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeigthedGraph {

    private int V;
    private final List<List<Edge>> adj;

    public EdgeWeigthedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(final Edge e) {
        int v = e.either(), w = e.other(v);
        adj.get(v).add(e);
        adj.get(w).add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }
}
