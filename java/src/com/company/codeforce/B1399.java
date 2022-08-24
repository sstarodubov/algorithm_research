import java.util.Arrays;
import java.util.Scanner;

public class B1399 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            var a = read(n, sc);
            var b = read(n, sc);
            long am = Arrays.stream(a).min().getAsLong();
            long bm = Arrays.stream(b).min().getAsLong();
            long ans = 0;

            for (int j = 0; j < n; j++) {
                long ad = a[j] - am;
                long bd = b[j] - bm;

                if (b[j] == bm) {
                    ans += ad;
                } else if (a[j] == am) {
                    ans += bd;
                } else {
                    if (ad == bd) {
                        ans += ad;
                    } else if (ad < bd) {
                        ans += (ad + (bd - ad));
                    } else {
                        ans += (bd + (ad - bd));
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static long[] read(int size, final Scanner sc) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
