package graph;

public interface Graph {
    /**
     * add edge
     */
    void addEdge(int v, int w);

    // vertices adjacent to v
    Iterable<Integer> adj(int v);

    //number of vertices
    int V();

    //number of edges
    int E();
}
