import java.util.Scanner;

public class A581 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int d = Math.min(a, b);
        int mx = Math.max(a, b);


        System.out.printf("%d %d%n", d, (mx - d) / 2);

    }
}
