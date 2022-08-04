package p800;

import java.util.Scanner;

public class Dominopiling {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sq = m * n;

        System.out.println(sq / 2);
    }
}
