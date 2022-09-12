import java.util.Scanner;

public class A1186 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int d = Math.min(m, k);
        if (n <= d) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
