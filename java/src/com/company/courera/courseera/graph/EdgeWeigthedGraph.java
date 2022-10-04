package graph;

import unionFind.QuickFind;
import unionFind.UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class EdgeWeigthedGraph {

    public static void main(String[] args) {
        final EdgeWeigthedGraph graph = new EdgeWeigthedGraph(6);
        graph.addEdge(new Edge(0, 4, 0.1));
        graph.addEdge(new Edge(0, 3, 0.1));
        graph.addEdge(new Edge(1, 2, 0.1));
        graph.addEdge(new Edge(2, 5, 0.2));
        graph.addEdge(new Edge(4, 1, 0.6));
        graph.addEdge(new Edge(4, 0, 0.3));
        graph.addEdge(new Edge(4, 5, 0.3));
        graph.addEdge(new Edge(5, 3, 1));

        System.out.println(graph.kruskalMST());
        System.out.println(graph.primMST());
    }

    private int V;
    private final List<List<Edge>> adj;
    private final List<Edge> edges;


    public EdgeWeigthedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public List<Edge> primMST() {
        final var mst = new ArrayList<Edge>(V + 1);
        final var pq = new PriorityQueue<Edge>();
        final var marked = new boolean[V];
        Consumer<Integer> visit = (vertex) -> {
            marked[vertex] = true;
            for (Edge e : this.adj(vertex)) {
                if (!marked[e.other(vertex)]) pq.add(e);
            }
        };

        visit.accept(0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            if (!marked[v]) visit.accept(v);
            if (!marked[w]) visit.accept(w);
        }

        return mst;
    }

    public List<Edge> kruskalMST() {
        final var mst = new ArrayList<Edge>(V + 1);
        final var pq = new PriorityQueue<Edge>();
        pq.addAll(this.edges);
        final UnionFind uf = new QuickFind(V);
        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(w, v);
                mst.add(e);
            }
        }

        return mst;
    }

    public void addEdge(final Edge e) {
        int v = e.either(), w = e.other(v);
        adj.get(v).add(e);
        adj.get(w).add(e);
        edges.add(e);
    }

    public void removeEdge(final Edge e) {
        int v = e.either(), w = e.other(v);
        adj.get(v).remove(e);
        adj.get(w).remove(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj.get(v);
    }

    public int V() {
        return V;
    }
}
