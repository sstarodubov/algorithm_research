package com.company.datastructureimpl;

public class UnionFind {

    private final int size;
    private final int[] sz;
    private final int[] id;

    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        numComponents = size;
        sz = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int components() {
        return numComponents;
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2) return;

        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        numComponents--;

    }

}
