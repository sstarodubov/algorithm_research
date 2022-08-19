import java.util.Scanner;

public class A1560 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            System.out.println(helper(k));
        }
    }

    public static int helper(int k) {
        int val = 0;
        int idx = 1;

        while (idx <= k) {
            val++;
            if (check(val)) {
                idx++;
            }
        }

        return val;
    }

    private static boolean check(int n) {

        if ((n % 10) == 3) {
            return false;
        }

        if ((n % 3) == 0) {
            return false;
        }

        return true;
    }
}
