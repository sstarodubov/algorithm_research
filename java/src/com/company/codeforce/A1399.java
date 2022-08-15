import java.util.Arrays;
import java.util.Scanner;

public class A1399 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int[] arr = read(sc.nextInt(), sc);
            Arrays.sort(arr);
            boolean fl = true;
            for (int j = arr.length - 1; j > 0; j--) {
                if (Math.abs(arr[j] - arr[j - 1]) > 1) {
                    System.out.println("NO");
                    fl = false;
                    break;
                }
            }
            if (fl) {
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
