package graph;

public interface Graph<T> {
    /**
     * add edge
     */
    void addEdge(int v, int w);

    // vertices adjacent to v
    Iterable<T> adj(int v);

    //number of vertices
    int V();

    //number of edges
    int E();
}
