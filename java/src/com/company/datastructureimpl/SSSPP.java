package com.company.datastructureimpl;


import java.util.*;

class NodeS {
    public final String name;
    public boolean visited = false;
    public NodeS parent = null;

    public NodeS(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class SSSPP {
    public static void main(String[] args) {
        var A = new NodeS("A");
        var B = new NodeS("B");
        var C = new NodeS("C");
        var D = new NodeS("D");
        var F = new NodeS("F");
        var E = new NodeS("E");
        var G = new NodeS("G");
        Map<NodeS, Set<NodeS>> graph = Map.of(
                A, Set.of(C, B),
                B, Set.of(A, D, G),
                C, Set.of(E, A, D),
                D, Set.of(C, B, F),
                E, Set.of(C, F),
                F, Set.of(E, G, D),
                G, Set.of(B, F)
        );
        var path = sssppOfUnweightedGraph(F, A, graph);
        if (path.isEmpty()) System.out.println("path does not exist");
        else System.out.println(path);
    }

    public static Deque<NodeS> sssppOfUnweightedGraph(final NodeS start,
                                                      final NodeS end,
                                                      final Map<NodeS, Set<NodeS>> graph) {
        var ssspp = new ArrayDeque<NodeS>();
        var dq = new ArrayDeque<NodeS>();
        dq.add(start);
        while (!dq.isEmpty()) {
            var cur = dq.pollFirst();
            cur.visited = true;
            if (cur == end) break;
            var children = graph.get(cur);
            for (var child : children) {
                if (child.visited) continue;
                child.parent = cur;
                dq.addLast(child);
            }
        }
        var cur = end;
        while (cur != null) {
            ssspp.addFirst(cur);
            cur = cur.parent;
        }
        return ssspp;
    }
}
