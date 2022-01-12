package com.company.datastructureimpl;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        var nodes = List.of(
                new WeightedNode("A", 0),
                new WeightedNode("B", 1),
                new WeightedNode("C", 2),
                new WeightedNode("D", 3),
                new WeightedNode("E", 4),
                new WeightedNode("G", 5),
                new WeightedNode("F", 6)
        );

        var g = new WeightGraph(nodes);
        g.addWeightedEdge(0, 1, 2);
        g.addWeightedEdge(0, 2, 5);
        g.addWeightedEdge(1, 3, 1);
        g.addWeightedEdge(1, 4, 3);
        g.addWeightedEdge(2, 6, 8);
        g.addWeightedEdge(3, 4, 4);
        g.addWeightedEdge(4, 5, 9);
        g.addWeightedEdge(6, 5, 7);
        g.dijkstra(nodes.get(0));
    }
}

class WeightGraph {
    public List<WeightedNode> nodes = new ArrayList<>();

    public WeightGraph(List<WeightedNode> nodes) {
        this.nodes = nodes;
    }

    public void dijkstra(WeightedNode node) {
        var heap = new PriorityQueue<WeightedNode>();
        node.distance = 0;
        heap.addAll(nodes);
        while (!heap.isEmpty()) {
            var cur = heap.poll();
            for (var n : cur.neighbors) {
                if (heap.contains(n)) {
                    if (n.distance > cur.distance + cur.wMap.get(n)) {
                        n.distance = cur.distance + cur.wMap.get(n);
                        n.parent = cur;
                        heap.remove(n);
                        heap.add(n);
                    }
                }
            }
        }

        for (var n : nodes) {
            System.out.println("Node " + n + ", distance " + n.distance + " ,Path:");
            pathPrint(n);
            System.out.println();
            System.out.println("============");
        }
    }

    public void pathPrint(WeightedNode w) {
        if (w.parent != null) {
            pathPrint(w.parent);
        }
        System.out.print(w + ",");
    }

    public void addWeightedEdge(int i, int j, int d) {
        var a = nodes.get(i);
        var b = nodes.get(j);
        a.wMap.put(b, d);
        a.neighbors.add(b);

    }
}


class WeightedNode implements Comparable<WeightedNode> {
    public String name;
    public List<WeightedNode> neighbors = new ArrayList<>();
    public Map<WeightedNode, Integer> wMap = new HashMap<>();
    public WeightedNode parent;
    public boolean visited = false;
    public int distance = Integer.MAX_VALUE;
    public int idx;

    public WeightedNode(String name, int indx) {
        this.idx = indx;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }
}
