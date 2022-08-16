import java.util.Scanner;

public class A472 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long a = n / 2;
        long b = (n & 1) == 0 ? a : a + 1;
        while (true) {
            if (!isPrime(a) && !isPrime(b)) {
                System.out.printf("%d %d", b, a);
                return;
            } else {
                a--;
                b++;
            }
        }
    }


    private static boolean isPrime(long num) {
        if (num == 2) return true;
        if (num == 3) return true;
        return (num * num) % 24 == 1;
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
