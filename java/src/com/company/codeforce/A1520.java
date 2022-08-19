import java.util.HashSet;
import java.util.Scanner;

public class A1520 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String sh = sc.next();

            if (helper(sh)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
    private static boolean helper(String sh) {
        var prev = sh.charAt(0);
        var set = new HashSet<Character>();
        set.add(prev);

        for (int j = 1; j < sh.length(); j++) {
            if (prev == sh.charAt(j)) {
                continue;
            } else {
                if (set.contains(sh.charAt(j))) {
                    return false;
                } else {
                    set.add(sh.charAt(j));
                    prev = sh.charAt(j);
                }
            }
        }
        return true;
    }
}
