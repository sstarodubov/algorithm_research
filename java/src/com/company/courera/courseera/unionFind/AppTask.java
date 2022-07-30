package unionFind;

import java.util.Scanner;

public class AppTask {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        var uf = new UF(matrix);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1 && col + 1 < n && matrix[row][col + 1] == 1) {
                    uf.union(n, col, row, col + 1, row);
                }
                if (matrix[row][col] == 1 && row + 1 < n && matrix[row + 1][col] == 1) {
                    uf.union(n, col, row, col, row + 1);
                }
            }
        }

        if (uf.isPercolated()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class UF {

    private final int[] groupId;
    private final int vsId;
    private final int veId;

    public UF(int[][] matrix) {
        final int n = (matrix.length * matrix[0].length);
        groupId = new int[n + 2];
        int p = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                groupId[p] = p;
                p++;
            }
        }

        vsId = n;
        veId = n + 1;
        groupId[veId] = veId;
        groupId[vsId] = vsId;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] == 1) {
                int curId = getId(matrix.length, i, 0);
                union(curId, vsId);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[matrix.length - 1][i] == 1) {
                int curId = getId(matrix.length, i, matrix.length - 1);
                union(curId, veId);
            }
        }
        System.out.println("");
    }

    public boolean isPercolated() {
        return root(vsId) == root(veId);
    }

    public void union(int n, int c1, int r1, int c2, int r2) {
        int id1 = getId(n, c1, r1);
        int id2 = getId(n, c2, r2);
        union(id1, id2);
    }

    private void union(int id1, int id2) {
        int p = root(id1);
        int q = root(id2);
        groupId[p] = q;
    }

    private int getId(int n, int col, int row) {
        return col + row * n;
    }

    private void compress(int id) {
        groupId[id] = groupId[groupId[id]];
    }

    private int root(int id) {
        while (id != groupId[id]) {
            compress(id); // optimization
            id = groupId[id];
        }
        return id;
    }
}