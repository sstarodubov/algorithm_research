package p800;

import java.util.Scanner;

public class A1650 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        String s = sc.next();
        String c = sc.next();
        int idx = -1;
        while (true) {
            idx = s.indexOf(c, idx + 1);
            if (idx == -1) {
                System.out.println("NO");
                return;
            }

            int ds = idx - 1;
            int es = s.length() - idx;
            if ((ds & 1) == 1 && (es & 1) == 1) {
                System.out.println("YES");
                return;
            }
        }
    }
}
