import java.util.Scanner;

public class A1692 {

    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int[] arr = read(4, sc);
            int ans = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > arr[0]) ans++;
            }
            System.out.println(ans);
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
