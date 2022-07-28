import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Sale {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = read(n);
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] < 0) {
                ans += Math.abs(arr[i]);
            }
        }
        System.out.println(ans);
    }

    public static int[] read(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
