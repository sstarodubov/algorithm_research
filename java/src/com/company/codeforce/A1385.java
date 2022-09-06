import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A1385 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            var arr = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("YES");
                print(arr);
            } else if (arr[1] == arr[2]) {
                System.out.println("YES");
                System.out.printf("%d %d %d\n", arr[0], arr[0], arr[1]);
            } else {
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
}
