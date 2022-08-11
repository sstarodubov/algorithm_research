import java.util.Scanner;

public class A510 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean r = true;
        boolean f = true;
        for (int i = 0; i < n; i++) {
            if (r) {
                for (int j = 0; j < m; j++) {
                    if (j != m - 1) System.out.print("#");
                    else System.out.println("#");
                }
                r = false;
            } else {
                for (int j = 0; j < m; j++) {
                    if (j != m - 1) {
                        if (j == 0 && !f) {
                            System.out.print("#");
                        } else {
                            System.out.print(".");
                        }
                    } else {
                        if (!f) {
                            System.out.println(".");
                        } else {
                            System.out.println("#");
                        }
                    }
                }
                r = true;
                f = !f;
            }
        }
    }
}
