import java.util.Scanner;

public class CalculatingFunction {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        var n = sc.nextLong();
        if ((n & 1) == 0) {
            System.out.println(n / 2);
        } else {
            System.out.println(((n - 1) / 2) - n);
        }
        sc.close();
    }
}
