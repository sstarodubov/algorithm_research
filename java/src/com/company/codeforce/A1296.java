import java.util.Arrays;
import java.util.Scanner;

public class A1296 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = read(n, sc);
            int sum = Arrays.stream(arr).sum();
            if ((sum & 1) == 1) {
                System.out.println("YES");
            } else {
                boolean even = false;
                boolean odd = false;

                for (int j = 0; j < arr.length; j++) {
                    if ((arr[j] & 1) == 1) {
                        odd = true;
                    } else {
                        even = true;
                    }
                }

                if (even && odd) {
                    System.out.println("YES");
                } else {
                    if ((arr.length & 1) == 1) {
                        if (odd) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                    } else {
                        System.out.println("NO");
                    }
                }
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
