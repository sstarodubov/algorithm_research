import java.util.HashMap;
import java.util.Scanner;

public class A141 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var s1 = sc.next();
        var s2 = sc.next();
        var t = sc.next();
        var mp = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            mp.computeIfPresent(t.charAt(i), (k, v) -> v + 1);
            mp.putIfAbsent(t.charAt(i), 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            int c = mp.getOrDefault(s1.charAt(i), 0);
            if ((c - 1) == -1) {
                System.out.println("NO");
                return;
            }

            mp.put(s1.charAt(i), c - 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            int c = mp.getOrDefault(s2.charAt(i), 0);
            if ((c - 1) == -1) {
                System.out.println("NO");
                return;
            }

            mp.put(s2.charAt(i), c - 1);
        }

        for (var en : mp.entrySet()) {
            if (en.getValue() != 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
