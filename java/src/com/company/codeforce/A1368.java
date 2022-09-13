import java.util.Scanner;

public class A1368 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        boolean f = a < b;
        int ans = 0;
        while (a <= n && b <= n) {
            if (f) {
                a += b;
                f = false;
            } else {
                b += a;
                f = true;
            }
            ans++;
        }

        System.out.println(ans);
    }
}
