import java.io.IOException;
import java.util.Scanner;

public class Magnets {

    public static void main(String[] args) throws IOException {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();

        String prev = null;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                var cur = sc.next();
                if (cur.charAt(0) == prev.charAt(prev.length() - 1)) {
                    ans++;
                }
                prev = cur;
            } else {
                prev = sc.next();
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
