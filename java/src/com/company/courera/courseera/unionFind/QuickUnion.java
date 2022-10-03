package unionFind;

public class QuickUnion implements UnionFind {

    private final int[] groupId;

    public QuickUnion(int[] id) {
        this.groupId = id;
    }

    public QuickUnion(int n) {
        groupId = new int[n];
        for (int i = 0; i < n; i++) {
            groupId[i] = i;
        }
    }

    private int root(int node) {
        while (node != groupId[node]) {
            groupId[node] = groupId[groupId[node]]; // compression
            node = groupId[node];
        }
        return node;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        groupId[qid] = pid;
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
        var qu = new QuickUnion(10);
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
