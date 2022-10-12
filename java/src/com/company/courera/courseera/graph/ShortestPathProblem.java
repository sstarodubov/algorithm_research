package graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

record DirectedEdge(int v, int w, double weigth) implements Comparable<DirectedEdge> {
    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public int compareTo(@NotNull DirectedEdge directedEdge) {
        return Double.compare(weigth, directedEdge.weigth);
    }
}

class EdgeWeightedDirectedGraph {
    private final int V;
    private final List<List<DirectedEdge>> adj;
    private final List<DirectedEdge> edges = new ArrayList<>();
    private final double[] distTo;
    private final DirectedEdge[] edgeTo;

    public EdgeWeightedDirectedGraph(int V) {
        this.V = V;
        distTo = new double[V];
        edgeTo = new DirectedEdge[V];
        Arrays.fill(distTo, Double.MAX_VALUE);
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public double dikstra(int from, int target) {
        final var pq = new MinIndexedDHeap<Double>(V);
        distTo[from] = 0;
        pq.insert(from, 0.0);

        while (!pq.isEmpty()) {
            int v = pq.pollMinKeyIndex();
            for (var edge : adj.get(v)) {
                if (relax(edge)) {
                    if (pq.contains(edge.to())) pq.decrease(edge.to(), edge.weigth());
                    else pq.insert(edge.to(), edge.weigth());
                }
            }

            if (v == target) return distTo[target];
        }

        return distTo[target];
    }

    private boolean relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weigth()) {
            distTo[w] = distTo[v] + e.weigth();
            edgeTo[w] = e;
            return true;
        }

        return false;
    }

    void addEdge(DirectedEdge e) {
        int v = e.from();
        adj.get(v).add(e);
        edges.add(e);
    }

    public Collection<DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }

    public Collection<DirectedEdge> edges() {
        return edges;
    }
}

public class ShortestPathProblem {
    public static void main(String[] args) {
        final var graph = new EdgeWeightedDirectedGraph(8);
        graph.addEdge(new DirectedEdge(0, 1, 5));
        graph.addEdge(new DirectedEdge(0, 7, 8));
        graph.addEdge(new DirectedEdge(0, 4, 9));
        graph.addEdge(new DirectedEdge(1, 3, 15));
        graph.addEdge(new DirectedEdge(1, 7, 4));
        graph.addEdge(new DirectedEdge(1, 2, 12));
        graph.addEdge(new DirectedEdge(3, 6, 9));
        graph.addEdge(new DirectedEdge(4, 5, 4));
        graph.addEdge(new DirectedEdge(4, 7, 5));
        graph.addEdge(new DirectedEdge(4, 6, 20));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(5, 6, 13));
        graph.addEdge(new DirectedEdge(7, 5, 6));
        graph.addEdge(new DirectedEdge(7, 2, 7));


        double dikstra = graph.dikstra(0, 6);
        System.out.println(dikstra == Double.MAX_VALUE ? "Inf" : dikstra);
    }
}
