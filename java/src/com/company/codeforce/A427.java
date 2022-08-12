import java.util.Scanner;

public class A427 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();

        int h = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();

            if (e == -1) {
                if (h == 0) {
                    ans++;
                } else {
                    h--;
                }
            } else {
                h += e;
            }
        }

        System.out.println(ans);
    }
}
