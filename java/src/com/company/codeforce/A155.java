import java.util.Scanner;

public class A155 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mn = sc.nextInt();
        int mx = mn;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int cur = sc.nextInt();

            if (cur > mx) {
                ans++;
                mx = cur;
            } else if (cur < mn) {
                ans++;
                mn = cur;
            }
        }

        System.out.println(ans);
    }
}
