import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1722 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        String s = sc.next();
        if (n != 5) {
            System.out.println("NO");
            return;
        }

        var hm = new HashMap<>(Map.of(
                'T', 1,
                'i', 1,
                'm', 1,
                'u', 1,
                'r', 1
        ));

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.computeIfPresent(s.charAt(i), (k, v) -> v - 1);
            } else {
                System.out.println("NO");
                return;
            }
        }

        for (var ent : hm.entrySet()) {
            if (ent.getValue() != 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
