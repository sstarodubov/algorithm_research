package p800;

import java.util.Scanner;

public class BearBrother {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int ans = 0;
        while (a <= b) {
            a = a * 3;
            b = b * 2;
            ans++;
        }

        System.out.println(ans);
    }
}
