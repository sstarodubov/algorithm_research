package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BusinessTrip {

    private static final Scanner sc = new Scanner(System.in);
    // private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int k = sc.nextInt();
        if (k == 0) {
            System.out.println(0);
            return;
        }
        Integer[] m = read(12);
        Arrays.sort(m, Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += m[i];
            if (sum >= k) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    public static Integer[] read(int size) {
        var arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
