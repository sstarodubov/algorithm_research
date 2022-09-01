package p800;

import java.util.Scanner;

public class A732 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int r = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            int s = k * i;
            if ((s % 10) == r || (s % 10) == 0) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(10);
    }
}
