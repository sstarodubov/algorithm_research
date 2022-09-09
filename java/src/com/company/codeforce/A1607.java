import java.util.HashMap;
import java.util.Scanner;

public class A1607 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t ; i++) {
            fn(sc);
        }
    }

    private static void fn(Scanner sc) {
        var hm = new HashMap<Character, Integer>();
        var al = sc.next();
        for (int i = 0; i < al.length(); i++) {
            hm.put(al.charAt(i), i);
        }

        var word  = sc.next();
        int ans = 0;
        char cur = word.charAt(0);
        for (int i = 1; i < word.length() ; i++) {
            char p = word.charAt(i);
            ans += Math.abs(hm.get(cur) - hm.get(p));
            cur = p;
        }

        System.out.println(ans);
    }
}
