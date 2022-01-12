package com.company.datastructureimpl;

import java.util.*;

class Node {
    public final String name;
    public boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class TopologicalSortMain {
    public static void main(String[] args) {
        var A = new Node("A");
        var B = new Node("B");
        var C = new Node("C");
        var D = new Node("D");
        var F = new Node("F");
        var E = new Node("E");
        var H = new Node("H");
        var G = new Node("G");
        Map<Node, Set<Node>> graph = Map.of(
                A, Set.of(C),
                B, Set.of(C, D),
                C, Set.of(E),
                D, Set.of(H),
                F, Set.of(G),
                E, Set.of(H, F),
                H, Set.of(),
                G, Set.of()
        );

        Deque<Node> topsort = topsort(graph);
        System.out.println(topsort);

    }

    public static Deque<Node> topsort(Map<Node, Set<Node>> graph) {
        var topsort = new ArrayDeque<Node>();
        for (var node : graph.keySet()) {
            if (!node.visited) {
                dfs(node, graph, topsort);
            }
        }
        return topsort;
    }

    public static void dfs(Node node, Map<Node, Set<Node>> g, Deque<Node> ts) {
        if (node.visited) {
            return;
        }

        node.visited = true;

        for (var child : g.get(node)) {
            dfs(child, g, ts);
        }
        ts.addFirst(node);
    }
}

