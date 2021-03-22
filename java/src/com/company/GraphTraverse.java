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
public class GraphTraverse {
    public static void main(String[] args) {
        var graph = new Graph();
        var A = new Vertex("A");
        var B = new Vertex("B");
        var C = new Vertex("C");
        var E = new Vertex("E");
        var F = new Vertex("F");
        var I = new Vertex("I");
        var J = new Vertex("J");
        var D = new Vertex("D");
        var H = new Vertex("H");
        var G = new Vertex("G");
        var K = new Vertex("K");


        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(I);
        graph.addVertex(J);
        graph.addVertex(D);
        graph.addVertex(H);
        graph.addVertex(G);
        graph.addVertex(K);

        graph.addEdges(A, List.of(B, C, D));
        graph.addEdges(B, List.of(E, F));
        graph.addEdges(C, Collections.emptyList());
        graph.addEdges(E, Collections.emptyList());
        graph.addEdges(F, List.of(I, J));
        graph.addEdges(I, Collections.emptyList());
        graph.addEdges(J, Collections.emptyList());
        graph.addEdges(D, List.of(G, H));
        graph.addEdges(H, Collections.emptyList());
        graph.addEdges(G, List.of(K));
        graph.addEdges(K, Collections.emptyList());

        var result = graph.depthFirstSearch(A, new ArrayList<>());
        var res = graph.breadthFirstSearch(A);
        System.out.println(res);
    }
}


class Vertex {
    public String name;
    public boolean isVisited = false;

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Graph {
    private final Map<Vertex, List<Vertex>> adj;
    private final Queue<Vertex> queue;

    public Graph() {
        queue = new LinkedList<>();
        adj = new HashMap<>();
    }

    void addEdge(Vertex src, Vertex newEdge) {
        adj.get(src).add(newEdge);
    }

    void addVertex(Vertex newVertex) {
        adj.put(newVertex, new LinkedList<>());
    }

    void addEdges(Vertex src, List<Vertex> edges) {
        adj.put(src, edges);
    }

    List<Vertex> depthFirstSearch(Vertex curVert, List<Vertex> vertexes) {
        if (curVert == null) return vertexes;
        vertexes.add(curVert);
        List<Vertex> children = adj.get(curVert);
        for (var child : children) {
            depthFirstSearch(child, vertexes);
        }
        return vertexes;
    }

    List<Vertex> breadthFirstSearch(Vertex vertex) {
        var result = new LinkedList<Vertex>();
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Vertex curVertex = queue.poll();
            if (!curVertex.isVisited) {
                curVertex.isVisited = true;
                result.add(curVertex);
                List<Vertex> vertices = adj.get(curVertex);
                queue.addAll(vertices);
            }
        }
        return result;
    }
}