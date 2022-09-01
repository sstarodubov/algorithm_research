import java.util.*;

// 1 2 3 4 5 6

// 6 5 4 5
public class A1454 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            helper(n);
        }
    }

    private static void helper(int n) {
        List<Integer> arr = new ArrayList<>(n);
        for (int i = n, j = 0; i >= 1; i--, j++) {
            arr.add(i);
        }
        int m = arr.size() /2;

        if ((arr.size() & 1) == 1) {
            Collections.swap(arr, m, 0);
        }

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
