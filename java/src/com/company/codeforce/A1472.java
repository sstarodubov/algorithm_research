import java.util.Scanner;

public class A1472 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            helper(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }

    public static void helper(int w, int h, int n) {
        int c = 1;
        while (c < n) {
            if ((w & 1) == 0) {
                w = w / 2;
                c *= 2;
            } else if ((h & 1) == 0) {
                h = h / 2;
                c *= 2;
            } else {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }
}
