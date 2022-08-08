import java.util.Scanner;

public class GeorgeandAccommodation {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            if (q - p >= 2) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
