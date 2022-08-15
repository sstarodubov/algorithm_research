import java.util.Arrays;
import java.util.Scanner;

public class A1154 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int[] arr = read(4, sc);
        Arrays.sort(arr);
        int abc = arr[3];
        int bc = arr[0];
        int ac = arr[1];
        int ab = arr[2];

        int a = abc - bc;
        int b = ab - a;
        int c = ac - a;

        System.out.printf("%d %d %d%n", a, b, c);
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
