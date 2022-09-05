import java.util.HashSet;
import java.util.Scanner;

public class B1385 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = read(n * 2, sc);
            helper(arr, n);
        }
    }

    private static void helper(int[] arr, int n) {
        var set = new HashSet<Integer>();
        int[] ans = new int[n];
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            ans[p++] = arr[i];
            set.add(arr[i]);
        }

        print(ans);
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
