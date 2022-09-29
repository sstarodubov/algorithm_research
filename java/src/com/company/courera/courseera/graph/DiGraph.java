package graph;

import java.util.*;

public class DiGraph implements Graph<Integer> {

    public static void main(String[] args) {
        DiGraph diGraph = new DiGraph(13);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 5);
        diGraph.addEdge(2, 0);
        diGraph.addEdge(2, 3);
        diGraph.addEdge(3, 5);
        diGraph.addEdge(3, 2);
        diGraph.addEdge(4, 3);
        diGraph.addEdge(4, 2);
        diGraph.addEdge(5, 4);
        diGraph.addEdge(6, 8);
        diGraph.addEdge(6, 0);
        diGraph.addEdge(6, 4);
        diGraph.addEdge(6, 9);
        diGraph.addEdge(7, 6);
        diGraph.addEdge(7, 9);
        diGraph.addEdge(8, 6);
        diGraph.addEdge(9, 10);
        diGraph.addEdge(9, 11);
        diGraph.addEdge(10, 12);
        diGraph.addEdge(11, 12);
        diGraph.addEdge(11, 4);
        diGraph.addEdge(12, 9);

        diGraph.strongComponents();
    }

    private final int V;
    private final List<List<Integer>> adj;
    private int E = 0;


    public void strongComponents() {
        var scc = new int[V];

        var reversedGraph = this.reverse();
        List<Integer> postOrder = reversedGraph.postOrder();
        var visited = new HashSet<Integer>();
        int id = 0;
        for (var node : postOrder) {
            if (!visited.contains(node)) {
                this.sccDfs(node, visited, id++, scc);
            }
        }

        System.out.println(Arrays.toString(scc));
    }

    private void sccDfs(int w, Set<Integer> visited, int id, int[] scc) {
        if (visited.contains(w)) return;

        visited.add(w);
        scc[w] = id;

        var list = this.adj.get(w);

        for (var n : list) {
            sccDfs(n, visited, id, scc);
        }
    }

    private List<Integer> postOrder() {
        var postOrder = new ArrayList<Integer>();
        var visited = new HashSet<Integer>();
        for (int i = 0; i < V; i++) {
            postOrder(i, postOrder, visited);
        }
        Collections.reverse(postOrder);
        return postOrder;
    }

    private void postOrder(int v, List<Integer> postOrder, Set<Integer> visited) {
        if (visited.contains(v)) return;

        visited.add(v);

        var ns = this.adj.get(v);

        for (var n : ns) {
            postOrder(n, postOrder, visited);
        }

        postOrder.add(v);
    }

    public DiGraph reverse() {
        DiGraph reverseGraph = new DiGraph(V);
        for (int i = 0; i < V; i++) {
            List<Integer> nodeList = adj.get(i);
            for (int destination : nodeList) {
                reverseGraph.addEdge(destination, i);
            }
        }
        return reverseGraph;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            List<Integer> nodeList = adj.get(i);
            System.out.print(i + " | -> ");
            for (Integer integer : nodeList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public void topologicalSort() {
        var topSort = new ArrayList<Integer>();
        var visited = new HashSet<Integer>();
        for (int n = 0; n < V; n++) {
            topologicalSort(n, topSort, visited);
        }
        Collections.reverse(topSort);
        System.out.println(topSort);
    }

    private void topologicalSort(int w, List<Integer> sorted, Set<Integer> visited) {
        if (visited.contains(w)) return;
        visited.add(w);
        var nList = this.adj.get(w);
        for (int n : nList) {
            topologicalSort(n, sorted, visited);
        }
        sorted.add(w);
    }

    private record Pair(int prev, int cur) {
    }

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
