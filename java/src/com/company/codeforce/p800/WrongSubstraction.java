package p800;

import java.util.Scanner;

public class WrongSubstraction {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        for (int i = 0; i < k; i++) {
            int ld = n % 10;
            if (ld == 0) n /= 10;
            else n--;
        }

        System.out.println(n);
    }
}
