import java.util.Scanner;

public class ConstructString {
    private final static Scanner sc = new Scanner(System.in);
    // private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            var uniq = new StringBuilder(alphabet.substring(0, b));
            while (uniq.length() < n) {
                uniq.append(uniq);
            }
            while (uniq.length() > n) {
                uniq.deleteCharAt(uniq.length() - 1);
            }

            System.out.println(uniq);
        }
    }
}
