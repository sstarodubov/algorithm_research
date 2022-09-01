package p800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1472 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            helper(sc);
        }
    }

    public static void helper(Scanner scanner) {
        int n = scanner.nextInt();
        var arr = read(n, scanner);
        Arrays.sort(arr, Comparator.reverseOrder());
        int ls = 0;
        int rs = 0;
        int i = 0;

        while (i < n) {

            while (i < n && ls != rs) {
                rs += arr[i++];
            }

            if (i >= n) break;
            ls += arr[i++];

        }

        if (ls == rs) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static Integer[] read(int size, final Scanner sc) {
        var arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
