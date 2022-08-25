import java.util.Scanner;

public class A1551 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int j = n / 3;
            if (n % 3 == 0) {
                System.out.printf("%d %d\n", j, j);
            } else {
                int c1 = j;
                int c2 = j + 1;
                if (c1 + (c2 * 2) == n) {
                    System.out.printf("%d %d\n", c1, c2);
                } else {
                    System.out.printf("%d %d\n", c2, c1);
                }
            }
        }
    }
}
