import java.util.Scanner;

public class B1722 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        var xs = sc.next();
        var ys = sc.next();

        for (int i = 0; i < n; i++) {
            char x = xs.charAt(i);
            char y = ys.charAt(i);

            if (x == y) {
                continue;
            }

            if (x == 'G' && y == 'B') {
                continue;
            }

            if (x == 'B' && y == 'G') {
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
