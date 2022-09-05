import java.util.Scanner;

public class A80 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (!isPrime(m)) {
            System.out.println("NO");
            return;
        }
        for (int i = n + 1; i < m; i++) {
            if (isPrime(i)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3)
            return true;
        if (num <= 1 || num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num ; i+=6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
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
