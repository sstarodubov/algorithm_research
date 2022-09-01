package p800;

import java.util.Scanner;

public class A1535 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[] arr = read(4, sc);

            int max = Math.max(arr[0], arr[1]);
            int min = Math.min(arr[0], arr[1]);

            int mmax = Math.max(arr[2], arr[3]);
            int mmin = Math.min(arr[2], arr[3]);

            if (mmax < min) {
                System.out.println("NO");
            } else if (max < mmin) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
