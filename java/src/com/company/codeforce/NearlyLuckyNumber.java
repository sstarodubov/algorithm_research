import java.io.IOException;
import java.util.Scanner;

public class NearlyLuckyNumber {

    public static void main(String[] args) throws IOException {
        final var sc = new Scanner(System.in);

        long i = sc.nextLong();
        long cn = 0;
        while (i != 0) {
            long n = i % 10;
            if (n == 4 || n == 7) cn++;
            i /= 10;
        }

        if (cn == 7 || cn == 4) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
}
