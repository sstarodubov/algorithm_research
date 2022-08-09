package p800;

import java.util.HashSet;
import java.util.Scanner;

public class TaskA469 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        var set = new HashSet<Integer>();

        int n = sc.nextInt();

        int xn = sc.nextInt();

        for (int i = 0; i < xn; i++) {
            set.add(sc.nextInt());
        }

        int yn = sc.nextInt();

        for (int i = 0; i < yn; i++) {
            set.add(sc.nextInt());
        }


        if (set.size() == n) {
            System.out.println("I become the guy.");
        } else {
            System.out.println("Oh, my keyboard!");
        }
    }
}
