import java.util.Scanner;

public class A1676 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            helper(n);
        }
    }

    private static void helper(int n) {
        int f = 0;

        for (int i = 0; i < 3; i++) {
            f += n % 10;
            n /= 10;
        }

        int s = 0;

        for (int i = 0; i < 3; i++) {
            s += n % 10;
            n /= 10;
        }

        if (f == s) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void displayArr(int[] arr) {
        final var sb = new StringBuilder();
        for (int j : arr) {
            sb.append(j).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }

    private static int[] readIntArr(Scanner sc, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }
}
