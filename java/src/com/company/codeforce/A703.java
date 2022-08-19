import java.util.Scanner;

public class A703 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int cm = sc.nextInt();
            int cc = sc.nextInt();
            if (cm > cc) {
                m++;
            } else if(cm < cc) {
                c++;
            }
        }

        if (m > c) {
            System.out.println("Mishka");
        } else if (m < c) {
            System.out.println("Chris");
        } else {
            System.out.println("Friendship is magic!^^");
        }
    }
}
