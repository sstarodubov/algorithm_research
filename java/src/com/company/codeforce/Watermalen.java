
import java.util.Scanner;

public class Watermalen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        
        for (int i = 1, j = n - 1; i < n; i++, j--) {
            if (i + j > n) continue;
            if ((i + j == n) && (j & 1) == 0 && (i & 1) == 0) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
