import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Twogram {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        var s = sc.next();
        var hm = new HashMap<String, Integer>();
        var sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(s.charAt(i - 1)).append(s.charAt(i));
            var k = sb.toString();
            var val = hm.getOrDefault(k, 0);
            hm.put(k, val + 1);
            sb.setLength(0);
        }

        int count = 0;
        var ans = "";
        for (var entry : hm.entrySet()) {
            if (entry.getValue() > count) {
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        System.out.println(ans);
    }
}
