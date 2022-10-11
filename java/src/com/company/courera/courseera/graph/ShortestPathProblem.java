package graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;

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
        distTo[from] = 0;
        var visited = new boolean[V];
        visited[from] = true;
        Collection<DirectedEdge> edges = adj(from);
        final var pq = new PriorityQueue<DirectedEdge>();
        pq.addAll(edges);

        while (!pq.isEmpty()) {
            DirectedEdge curEdge = pq.poll();
            if (visited[curEdge.to()]) continue;
            visited[curEdge.to()] = true;
            if (relax(curEdge)) {
                pq.addAll(adj(curEdge.to()));
            }
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

    void addBdEdge(DirectedEdge e) {
        int v = e.from();
        adj.get(v).add(e);
        adj.get(e.to()).add(e);
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
        final var graph = new EdgeWeightedDirectedGraph(9);
        graph.addBdEdge(new DirectedEdge(0, 1, 3));
        graph.addBdEdge(new DirectedEdge(0, 3, 2));
        graph.addBdEdge(new DirectedEdge(0, 8, 4));
        graph.addBdEdge(new DirectedEdge(1, 4, 7));
        graph.addBdEdge(new DirectedEdge(1, 7, 4));
        graph.addBdEdge(new DirectedEdge(7, 2, 2));
        graph.addBdEdge(new DirectedEdge(2, 5, 1));
        graph.addBdEdge(new DirectedEdge(5, 6, 8));
        graph.addBdEdge(new DirectedEdge(3, 4, 1));
        graph.addBdEdge(new DirectedEdge(8, 4, 8));
        graph.addBdEdge(new DirectedEdge(3, 2, 6));
        graph.addBdEdge(new DirectedEdge(8, 0, 4));

        double dikstra = graph.dikstra(7, 8);
        System.out.println(dikstra == Double.MAX_VALUE ? "Inf" : dikstra);
    }
}
