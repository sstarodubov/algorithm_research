package com.company;

import java.util.*;

/*
# Дан граф
                 _____A__
                /     \   \
             __B___    C   D
            /      \     /   \
           E       F    G     H
                  / \   \
                 I   J   K
нужно пройти по всем элементам его вершин

 */
public class DepthFirstSearchGraph {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("D");
        graph.addVertex("H");
        graph.addVertex("G");
        graph.addVertex("K");

        graph.addEdges("A", List.of("B", "C", "D"));
        graph.addEdges("B", List.of("E","F"));
        graph.addEdges("C", Collections.emptyList());
        graph.addEdges("E", Collections.emptyList());
        graph.addEdges("F", List.of("I", "J"));
        graph.addEdges("I", Collections.emptyList());
        graph.addEdges("J", Collections.emptyList());
        graph.addEdges("D", List.of("G", "H"));
        graph.addEdges("H", Collections.emptyList());
        graph.addEdges("G", List.of("K"));
        graph.addEdges("K", Collections.emptyList());

        var result = graph.depthFirstSearch("A", new ArrayList<>());
        System.out.println(result);

    }
}


class Graph {

    private final Map<String, List<String>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    void addEdge(String src, String newEdge) {
        adj.get(src).add(newEdge);
    }

    void addVertex(String newVertex) {
        adj.put(newVertex, new LinkedList<>());
    }

    void addEdges(String src, List<String> edges) {
        adj.put(src, edges);
    }

    List<String> depthFirstSearch(String curVert, List<String> vertexes) {
        if (curVert == null) return vertexes;
        vertexes.add(curVert);
        List<String> children = adj.get(curVert);
        for (var child : children) {
            depthFirstSearch(child, vertexes);
        }
        return vertexes;
    }
}