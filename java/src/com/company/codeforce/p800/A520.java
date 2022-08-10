package p800;

import java.util.HashSet;
import java.util.Scanner;

public class A520 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        var hm = new HashSet<Character>();

        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))) {
                hm.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        if (hm.size() == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
