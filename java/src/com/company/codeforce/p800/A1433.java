package p800;

import java.util.Scanner;

public class A1433 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] sArr = new int[]{1, 3, 6, 10};
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int d = n % 10;
            int prev = (d - 1) * 10;
            int size = size(n);

            int ans = prev + (sArr[size - 1]);
            System.out.println(ans);
        }
    }

    public static int size(int n) {
        int size = 0;
        while (n != 0) {
            n = n / 10;
            size++;
        }
        return size;
    }
}
