import java.util.Scanner;

public class A1335 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextInt();

            long l = n / 2;

            if (l > (n - l)) {
                System.out.println(n - l);
            } else {
                System.out.println(n - l - 1);
            }
        }

    }
}
