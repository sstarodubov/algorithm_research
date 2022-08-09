package p800;

import java.util.Scanner;

public class InSearchofanEasyProblem {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n =sc.nextInt();

        byte ans = 0;
        for (int i = 0; i < n; i++) {
            ans |= sc.nextByte();
        }

        if (ans == 1) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
