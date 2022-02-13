package com.company.datastructureimpl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DisjointSet {

    public Set<NodePath> nodeSet = new HashSet<>();

    public static void makeSet(Set<NodePath> set) {
        for (var node : set) {
            var ds = new DisjointSet();
            ds.nodeSet.add(node);
            node.disjointSet = ds;
        }
    }

    public static DisjointSet findSet(NodePath node) {
        return node.disjointSet;
    }

    public static void union(NodePath n1, NodePath n2) {
        if (n1.disjointSet == n2.disjointSet) return;

        if (n1.disjointSet.nodeSet.size() > n2.disjointSet.nodeSet.size()) {
            for (NodePath node : n2.disjointSet.nodeSet) {
                node.disjointSet = n1.disjointSet;
                n1.disjointSet.nodeSet.add(node);
            }

            return;
        }

        for (NodePath node : n1.disjointSet.nodeSet) {
            node.disjointSet = n2.disjointSet;
            n2.disjointSet.nodeSet.add(node);
        }
    }

    public static void main(String[] args) {
        var A = new NodePath("A");
        var B = new NodePath("B");
        var C = new NodePath("C");
        var D = new NodePath("D");
        var set = new HashSet<>(Set.of(A, B, C, D));
        DisjointSet.makeSet(set);

        union(A,B);
        union(A,D);
        System.out.println("end");
    }
}

class NodePath {
    public String name;
    public DisjointSet disjointSet;

    public NodePath(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof NodePath s)) return false;
        if (s.name == null || name == null) return false;
        return s.name.equals(name);
    }
}
