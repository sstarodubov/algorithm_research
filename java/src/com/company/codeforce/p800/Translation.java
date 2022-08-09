package p800;

import java.util.Scanner;

public class Translation {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var s = sc.next();
        var r = sc.next();

        if (s.length() != r.length()) {
            System.out.println("NO");
            return;
        }

        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) != r.charAt(j)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
