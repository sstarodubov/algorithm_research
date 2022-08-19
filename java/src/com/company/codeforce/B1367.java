import java.util.HashSet;
import java.util.Scanner;

public class B1367 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = read(n, sc);
            var odd = 0;
            var even = 0;
            for (int j = 0; j < a.length; j++) {
                if ((j & 1) == 0) {
                    if ((a[j] & 1) == 1) {
                        odd++;
                    }
                } else {
                    if ((a[j] & 1) == 0) {
                        even++;
                    }
                }
            }

            if (odd == even) {
                System.out.println(odd);
            } else {
                System.out.println(-1);
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
