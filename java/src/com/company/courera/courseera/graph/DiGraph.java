package graph;

import java.util.*;

public class DiGraph implements Graph {

    public static void main(String[] args) {
        DiGraph diGraph = new DiGraph(13);

        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 5);
        diGraph.addEdge(2, 0);
        diGraph.addEdge(2, 3);
        diGraph.addEdge(3, 5);
        diGraph.addEdge(3, 2);
        diGraph.addEdge(4, 2);
        diGraph.addEdge(4, 3);
        diGraph.addEdge(5, 4);
        diGraph.addEdge(6, 0);
        diGraph.addEdge(6, 4);
        diGraph.addEdge(6, 9);
        diGraph.addEdge(6, 8);
        diGraph.addEdge(7, 6);
        diGraph.addEdge(7, 9);
        diGraph.addEdge(8, 6);
        diGraph.addEdge(9, 10);
        diGraph.addEdge(9, 11);
        diGraph.addEdge(10, 12);
        diGraph.addEdge(11, 12);
        diGraph.addEdge(11, 4);
        diGraph.addEdge(12, 9);

        diGraph.bfs(12, 0);
    }

    private final int V;
    private final List<List<Integer>> adj;
    private int E = 0;

    private record Pair(int prev, int cur) {}

    public void bfs(int fr, int to) {
        int[] path = new int[V];
        var visited = new HashSet<Integer>();
        var dq = new ArrayDeque<Pair>();
        dq.add(new Pair(-1, fr));

        while (!dq.isEmpty()) {
            Pair pair = dq.pollFirst();
            int cur = pair.cur;
            int prev = pair.prev;
            if (visited.contains(cur)) continue;

            visited.add(cur);
            path[cur] = prev;

            if (cur == to) {
                int p = to;
                while (p != -1) {
                    System.out.print(p + " <-");
                    p = path[p];
                }
                System.out.println("EXISTS");
                return;
            }

            var nList = adj.get(cur);

            for (var n : nList) {
                dq.addLast(new Pair(cur, n));
            }
        }

        System.out.println("NOT EXIST");
    }

    public void dfs(int fr, int to) {
        int[] path = new int[V];
        boolean exists = dfs(fr, new HashSet<>(), to, path, -1);
        if (exists) {
            int cur = to;
            while (cur != -1) {
                System.out.print(cur + "<-");
                cur = path[cur];
            }
            System.out.println("EXISTS");
        } else System.out.println("NOT EXISTS");
    }

    private boolean dfs(int w, Set<Integer> visited, int target, int[] path, int prev) {
        if (visited.contains(w)) return false;

        visited.add(w);
        path[w] = prev;

        if (w == target) {
            return true;
        }
        var nList = adj.get(w);

        for (int n : nList) {
            boolean result = dfs(n, visited, target, path, w);
            if (result) return true;
        }
        return false;
    }

    public DiGraph(int v) {
        V = v;
        this.adj = new ArrayList<>(v);
        for (int i = 0; i < V; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    @Override
    public void addEdge(int v, int w) {
        this.adj.get(v).add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }
}
