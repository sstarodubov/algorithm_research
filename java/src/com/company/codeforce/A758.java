import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class A758 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = read(n, sc);
        int max = Arrays.stream(a).max().orElse(0);
        int ans = 0;
        for (int j : a) {
            ans += max - j;
        }
        System.out.println(ans);
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
