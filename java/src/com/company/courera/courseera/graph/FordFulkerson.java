package graph;

import java.util.*;

class FlowEdge {

    private final int v;
    private final int w;
    private final double capacity;
    private double flow;

    public FlowEdge(int v, int w, double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public double flow() {
        return flow;
    }

    public double capacity() {
        return capacity;
    }

    public int to() {
        return w;
    }

    public int from() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        if (vertex == w) return v;
        throw new RuntimeException();
    }

    public double residualCapacityTo(int vertex) {
        if (vertex == v) return flow;
        if (vertex == w) return capacity - flow;
        throw new RuntimeException();
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == v) flow -= delta;
        if (vertex == w) flow += delta;
        throw new RuntimeException();
    }
}

class FlowNetwork {

    private final int V;
    private List<List<FlowEdge>> adj;

    public FlowNetwork(int v) {
        V = v;
        adj = new ArrayList<>(V + 1);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj.get(v).add(e);
        adj.get(w).add(e);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj.get(v);
    }
}

public class FordFulkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0.0;
        while (hasAugmentingPath(G, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            }

            for (int v = t; v != s; edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottle);
            }

            value += bottle;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork g, int s, int t) {
        edgeTo = new FlowEdge[g.V()];
        marked = new boolean[g.V()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (FlowEdge edge : g.adj(v)) {
                int w = edge.other(v);
                if (edge.residualCapacityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = edge;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
        return marked[t];
    }

    public double value() {
        return value;
    }

    public boolean inCut(int v) {
        return marked[v];
    }
}
