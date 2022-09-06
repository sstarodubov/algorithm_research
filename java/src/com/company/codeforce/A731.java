import java.util.HashMap;
import java.util.Scanner;

public class A731 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        var s = sc.next();
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        var mp = new HashMap<Character, Integer>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], i);
        }

        char from = 'a';
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char to = s.charAt(i);
            var fromI = mp.get(from);
            Integer toi = mp.get(to);
            int x = Math.abs(fromI - toi);
            int y;
            if (fromI == toi) {
                y = 0;
            } else if (fromI > toi) {
                y = (26 - fromI) + toi;
            } else {
                y = (26 - toi) + fromI;
            }

            ans += Math.min(y, x);

            from = to;
        }

        System.out.println(ans);
    }
}
