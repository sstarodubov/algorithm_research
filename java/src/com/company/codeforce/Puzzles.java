import java.util.Arrays;
import java.util.Scanner;

public class Puzzles {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        int ws = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int r = ws - 1;
        int ans = Integer.MAX_VALUE;
        for (int l = 0; r < n; l++) {
            int diff = arr[r] - arr[l];
            ans = Math.min(ans, diff);
            r++;
        }

        System.out.println(ans);
    }
}
