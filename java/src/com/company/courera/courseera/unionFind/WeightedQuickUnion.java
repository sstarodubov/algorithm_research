package unionFind;

import java.util.Arrays;

public class WeightedQuickUnion {

    private final int[] groupId;
    private final int[] sz;

    public WeightedQuickUnion(int n) {
        groupId = new int[n];
        for (int i = 0; i < n; i++) {
            groupId[i] = i;
        }
        sz = new int[n];
        Arrays.fill(sz, 1);
    }

    private int root(int node) {
        while (node != groupId[node]) {
            groupId[node] = groupId[groupId[node]]; // compression
            node = groupId[node];
        }
        return node;
    }

    public boolean connected(int p, int q) {
        return groupId[p] == groupId[q];
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);

        if (pid == qid) return;
        if (sz[pid] < sz[qid]) {
            groupId[pid] = qid;
            sz[qid] += sz[pid];
        } else {
            groupId[qid] = pid;
            sz[pid] += sz[qid];
        }
    }

    public void display() {
        System.out.println("nodes: ");
        for (int i = 0; i < groupId.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("--------\n");
        System.out.println("groupId: ");
        for (int j : groupId) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        var qu = new WeightedQuickUnion(10);
        qu.union(9, 2);
        qu.union(2, 4);
        qu.union(2, 3);

        assert qu.connected(9, 2);
        assert qu.connected(2, 3);
        assert qu.connected(4, 3);
        assert qu.connected(9, 4);

        qu.display();
    }
}
