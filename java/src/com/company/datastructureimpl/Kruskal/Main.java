package com.company.datastructureimpl.Kruskal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // nodes
        var A = new Node("A", new DisjointSet());
        var B = new Node("B", new DisjointSet());
        var C = new Node("C", new DisjointSet());
        var D = new Node("D", new DisjointSet());
        var E = new Node("E", new DisjointSet());

        // build disjoint set
        var nodes = new HashSet<>(List.of(A, B, C, D, E));
        DisjointSet.buildDisjointSet(nodes);

        // build graph
        var edges = new ArrayList<>(List.of(
                new Edge(E, 15, A),
                new Edge(E, 20, C),
                new Edge(A, 5, B),
                new Edge(A, 13, C),
                new Edge(B, 10, C),
                new Edge(B, 8, D),
                new Edge(C, 6, D)
        ));

        // Kruskal

        edges.sort(Comparator.comparingInt(Edge::dist));

        var spanningTree = new ArrayList<Edge>();
        int counter = 0;

        for (var edge : edges) {
            if (counter >= nodes.size()) break;
            var from = edge.from();
            var to = edge.to();
            if (!DisjointSet.areNodeInSameDisjointSet(from, to)) {
                spanningTree.add(edge);
                DisjointSet.union(from, to);
                counter = from.disjointSet.collection.size();
            }
        }

        System.out.println(spanningTree);
    }
}

record Edge(Node from, int dist, Node to) {
}

class Node {
    public String name;
    public DisjointSet disjointSet;

    public Node(String name, DisjointSet disjointSet) {
        this.name = name;
        this.disjointSet = disjointSet;
    }

    @Override
    public String toString() {
        return name;
    }
}

class DisjointSet {


    Set<Node> collection = new HashSet<>();

    public static void buildDisjointSet(Set<Node> nodeSet) {
        for (var node : nodeSet) {
            node.disjointSet.collection.clear();
            node.disjointSet.collection.add(node);
        }
    }

    public static boolean areNodeInSameDisjointSet(Node n1, Node n2) {
        return n1.disjointSet == n2.disjointSet;
    }

    public static void union(Node n1, Node n2) {
        var s1 = n1.disjointSet.collection;
        var s2 = n2.disjointSet.collection;

        if (s1.size() > s2.size()) {
            for (var node : s2) {
                node.disjointSet = n1.disjointSet;
                n1.disjointSet.collection.add(node);
            }

            return;
        }
        for (var node : s1) {
            node.disjointSet = n2.disjointSet;
            n2.disjointSet.collection.add(node);
        }
    }
}