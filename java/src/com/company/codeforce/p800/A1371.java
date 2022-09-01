package p800;

import java.util.Scanner;

public class A1371 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            double n = sc.nextDouble();
            System.out.println((int) Math.ceil(n / 2));
        }
    }
}
