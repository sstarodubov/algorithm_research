import java.util.Scanner;

public class A702 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = read(n, sc);
        int ans = 1;
        int l = 0;
        int r = 1;
        for (; r < n; r++) {
            if (arr[r - 1] < arr[r]) {
                continue;
            }
            int d = r - l;
            ans = Math.max(ans, d);
            l = r;
        }

        int d = r - l;
        ans = Math.max(ans, d);

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
