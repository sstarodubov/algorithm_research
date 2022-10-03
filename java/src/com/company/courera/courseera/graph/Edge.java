package graph;

import org.jetbrains.annotations.NotNull;

public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weigth;

    public Edge(int v, int w, double weigth) {
        this.v = v;
        this.w = w;
        this.weigth = weigth;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        return v;
    }

    @Override
    public int compareTo(@NotNull Edge that) {
        if (this.weigth < that.weigth) return -1;
        else if (this.weigth > that.weigth) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Edge{v=%d,w=%d,weigth=%f}".formatted(v, w, weigth);
    }
}
