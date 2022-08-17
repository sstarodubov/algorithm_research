import java.util.Scanner;

public class A1512 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = read(n, sc);
            System.out.println(idx(a) + 1);
        }
    }

    public static int idx(int[] a) {
        int p = a[0];
        int pp = a[1];
        int base;

        if (p == pp) {
            base = p;
        } else {
            if (p == a[a.length - 1]) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] != base) {
                return i;
            }
        }
        return -1;
    }

    public static void print(int[] arr) {
        var s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        System.out.println(s);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
