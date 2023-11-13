package p1200;

import java.util.Scanner;
import java.util.TreeMap;

public class B474 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] as = new int[n];

        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] qs = new int[m];

        for (int i = 0; i < m; i++) {
            qs[i] = sc.nextInt();
        }

        var tree = new TreeMap<Integer, Integer>();
        int prev = 0;
        for (int i = 0; i < as.length; i++) {
            if (i == 0) {
                tree.put(1, 1);
                tree.put(as[i], 1);
                prev = as[i];
            } else {
                tree.put(prev + 1, i + 1);
                prev += as[i];
                tree.put(prev, i + 1);
            }
        }

        for (int i = 0; i < qs.length; i++) {
            if (tree.containsKey(qs[i])) {
                System.out.println(tree.get(qs[i]));
                continue;
            }
            Integer lv  = tree.lowerKey(qs[i]);
            if (lv != null) {
                System.out.println(tree.get(lv));
                continue;
            }
            System.out.println(tree.get(tree.higherKey(qs[i])));
        }
    }
}
