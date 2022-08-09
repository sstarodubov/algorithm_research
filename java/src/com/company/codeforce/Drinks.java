import java.util.Scanner;

public class Drinks {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        int n = sc.nextInt();
        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += sc.nextInt();
        }

        System.out.println(ans / n);

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
