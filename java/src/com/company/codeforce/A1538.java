import java.util.Scanner;

public class A1538 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = read(n, sc);
        int a = 0;
        int b = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[a]) {
                a = i;
            }
            if (arr[i] > arr[b]) {
                b = i;
            }
        }

        int ans = 0;
        int da = Math.min(a + 1, n - a);
        int db = Math.min(b + 1, n - b);
        if (da < db) {
            ans += da;
            int ddb = Math.min(Math.abs(a - b), Math.min(b + 1, n - b));
            ans += ddb;
        } else {
            ans += db;
            int dda = Math.min(Math.abs(a - b), Math.min(a + 1, n - a));
            ans += dda;
        }

        System.out.println(ans);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
