package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HQ {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        int p;
        while ((p = in.read()) != -1) {
            char ch = (char) p;
            if (ch == 'H') {
                System.out.println("YES");
                return;
            }
            if (ch == 'Q') {
                System.out.println("YES");
                return;
            }

            if (ch == '9') {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
