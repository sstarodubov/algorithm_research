package p800;

import java.util.Scanner;

public class A540 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        var xs = sc.next();
        var ys = sc.next();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = Character.getNumericValue(xs.charAt(i));
            int nxt = Character.getNumericValue(ys.charAt(i));

            if (cur != nxt) {
                int df = (Math.abs(nxt - cur));
                int db = ((10 - cur) + nxt);
                int da = ((10 - nxt) + cur);
                ans += Math.min(db, Math.min(df, da));
            }
        }

        System.out.println(ans);
    }
}
