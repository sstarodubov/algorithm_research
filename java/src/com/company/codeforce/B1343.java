import java.util.Scanner;

public class B1343 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int s = 0;
            for (int j = 0, v = 2; j < n / 2; j++, v += 2) {
                arr[j] = v;
                s += v;
            }

            int s2 = 0;
            int v = 1;
            for (int j = n / 2; j < n - 1; j++, v += 2) {
                s2 += v;
                arr[j] = v;
            }

            var curS = 0;
            while (s2 + v <= s) {
                curS = s2 + v;
                if (curS == s) {
                    System.out.println("YES");
                    arr[arr.length - 1] = v;
                    print(arr);
                    break;
                }
                v += 2;
            }

            if (curS != s) {
                System.out.println("NO");
            }
        }
    }

    public static void print(int[] arr) {
        var s = new StringBuilder();
        for (int j : arr) {
            s.append(j).append(" ");
        }
        s.deleteCharAt(s.length() - 1);
        System.out.println(s);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
