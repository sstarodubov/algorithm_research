import java.util.Scanner;

public class A1542 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = read(n * 2 , sc);

            fn(arr);

        }
    }

    private static void fn(int[] arr) {
        int odd = 0;
        int even = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 0) {
                even++;
            } else {
                odd++;
            }
        }

        if (odd == even) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
