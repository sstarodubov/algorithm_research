import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int ans = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < 3; j++) {
                int res = sc.nextInt();
                if (res == 1) cur++;
            }
            if (cur >= 2) ans++;
        }

        System.out.println(ans);
    }
}
