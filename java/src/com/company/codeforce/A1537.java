import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A1537 {

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
        double sum = Arrays.stream(arr).sum();
        double md = sum / arr.length;

        if (sum == n) {
            System.out.println(0);
        } else if (sum < n) {
            System.out.println(1);
        } else {
            int ans = (int) (sum - n);
            System.out.println(ans);
        }
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
