import java.util.Scanner;

public class A1370 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if ((n & 1) == 0) {
                System.out.println(n / 2);
            } else {
                System.out.println((n - 1) / 2);
            }
        }
    }
}
