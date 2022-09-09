import java.util.HashSet;
import java.util.Scanner;

public class B1325 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        int n = sc.nextInt();
        var set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        System.out.println(set.size());
    }
}
