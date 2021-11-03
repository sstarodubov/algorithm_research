package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = Map.of(
                0, List.of(new Edge(0, 1, 4), new Edge(0, 2, 1)),
                1, List.of(new Edge(1, 3, 1)),
                2, List.of(new Edge(2, 1, 2), new Edge(2, 3, 5)),
                3, List.of(new Edge(3, 4, 3)),
                4, List.of()
        );
        int ssssp = getSSSSP(graph, 0, 4);
        System.out.println(ssssp);
    }

    public static int getSSSSP(Map<Integer, List<Edge>> graph, int start, int end) {
        var pq = new PriorityQueue<Path>();
        pq.add(new Path(start, 0));
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while (!pq.isEmpty()) {
            var cur_path = pq.poll();
            int nodeId = cur_path.to;
            visited[nodeId] = true;

            for (Edge edge : graph.get(nodeId)) {
                if (visited[edge.to]) continue;
                int newDistance = distance[nodeId] + edge.weight;
                if (newDistance < distance[edge.to]) {
                    distance[edge.to] = newDistance;
                    pq.add(new Path(edge.to, edge.weight));
                }
            }

            if (nodeId == end) return distance[end];
        }

        return Integer.MAX_VALUE;
    }
}


class Path implements Comparable<Path> {
    public int to;
    public int distance;

    public Path(int to, int distance) {
        this.distance = distance;
        this.to = to;
    }


    @Override
    public int compareTo(Path path) {
        if (this.distance < path.distance) return -1;
        if (this.distance > path.distance) return 1;
        return 0;
    }
}

class Edge {
    public int from;
    public int to;
    public int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}


