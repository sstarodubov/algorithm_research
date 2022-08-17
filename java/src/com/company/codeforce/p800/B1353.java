package p800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1353 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            var a = read(n, sc);
            var b = read(n, sc);
            Arrays.sort(a);
            Arrays.sort(b, Comparator.reverseOrder());

            int bp = 0;
            int ap = 0;
            int p = 0;

            while (p < k && a[ap] < b[bp] ) {
                a[ap] = b[bp];
                ap++;
                bp++;
                p++;
            }

            System.out.println(Arrays.stream(a).reduce(0, Integer::sum));
        }
    }

    public static Integer[] read(int size, final Scanner sc) {
        var arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
