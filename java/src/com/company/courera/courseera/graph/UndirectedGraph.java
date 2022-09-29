package graph;

import java.util.*;

public class UndirectedGraph implements Graph<Integer> {

    private final int V;
    private final List<List<Integer>> adj;
    private int E = 0;
    private final int[] component;

    public UndirectedGraph(int v) {
        if (v < 0) throw new IllegalArgumentException("v is less than zero");
        V = v;
        this.adj = new ArrayList<>(v);
        for (int i = 0; i < V; i++) {
            this.adj.add(new ArrayList<>());
        }
        component = new int[v];
    }

    public void updateComponent() {
        int curId = 0;
        var list = new ArrayList<Integer>();
        var visited = new HashSet<Integer>();
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                dfs(i, list, visited, curId++);
            }
        }
    }

    public boolean isConnected(int w, int v) {
        return component[w] == component[v];
    }

    public List<Integer> dfs() {
        return dfs(0, new ArrayList<>(), new HashSet<>(), -1);
    }

    private List<Integer> dfs(final int node, final ArrayList<Integer> ans, final Set<Integer> visited, int curId) {
        if (visited.contains(node)) return ans;

        visited.add(node);
        ans.add(node);
        if (curId != -1) component[node] = curId;
        final List<Integer> neibors = adj.get(node);

        for (int neibor : neibors) {
            dfs(neibor, ans, visited, curId);
        }

        return ans;
    }

    private List<Integer> bfs() {
        var dq = new ArrayDeque<Integer>();
        dq.add(0);
        var visited = new HashSet<Integer>();
        var ans = new ArrayList<Integer>();
        while (!dq.isEmpty()) {
            int curNode = dq.pollFirst();
            if (visited.contains(curNode)) {
                continue;
            }

            visited.add(curNode);
            ans.add(curNode);
            var neibors = adj.get(curNode);
            dq.addAll(neibors);
        }

        return ans;
    }

    @Override
    public void addEdge(final int v, final int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        updateComponent();
        E++;
    }

    @Override
    public Iterable<Integer> adj(final int v) {
        return this.adj.get(v);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int curNode = 0; curNode < this.adj.size(); curNode++) {
            sb.append(curNode).append(" -> ");
            var n = this.adj.get(curNode).size();
            for (int i = 0; i < n; i++) {
                sb.append(this.adj.get(curNode).get(i));
                if (i != n - 1) sb.append(", ");
                else sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
