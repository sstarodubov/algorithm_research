package segvick;

import java.util.Scanner;

public class QuickFind {

    private final int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public void display() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("--------\n");
        for (int j : id) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var qf = new QuickFind(n);
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            qf.union(p, q);
        }

        qf.display();
    }
}
