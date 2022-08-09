package p800;

import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int r = -1;
        int c = -1;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                int n = sc.nextInt();
                if (n == 1) {
                    r = row;
                    c = col;
                }
            }
        }

        int dr = 0, dc = 0;

        if (r > 2) {
            dr = r - 2;
        } else if (r < 2) {
            dr = 2 - r;
        }

        if (c > 2) {
            dc = c - 2;
        } else if (c < 2) {
            dc = 2 - c;
        }

        System.out.println(dc + dr);
    }
}
