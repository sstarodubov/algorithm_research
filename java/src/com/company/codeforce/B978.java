import java.util.Scanner;

public class B978 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var s = sc.next();
        int c = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'x') {
                c++;
            } else {
                if (c >= 3) ans += c - 2;
                c = 0;
            }
        }

        if (c >= 3) ans += c - 2;
        System.out.println(ans);
    }
}
