import java.util.Scanner;

public class Bit {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            var statement = sc.next();
            if (statement.contains("+")) {
                ans++;
            } else if (statement.contains("-")) {
                ans--;
            }
        }

        System.out.println(ans);
    }
}
