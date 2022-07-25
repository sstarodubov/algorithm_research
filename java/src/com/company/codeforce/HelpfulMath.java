import java.util.Scanner;
import java.util.TreeMap;

public class HelpfulMath {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String s = sc.next();
        var tree = new TreeMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '+') continue;
            int val = tree.getOrDefault(cur, 0);
            tree.put(cur, val + 1);
        }

        var ans = new StringBuilder();

        while (!tree.isEmpty()) {
            Character ch = tree.firstKey();
            for (int i = 0; i < tree.get(ch); i++) {
                ans.append(ch).append('+');
            }
            tree.remove(ch);
        }

        ans.deleteCharAt(ans.length() - 1);

        System.out.println(ans);
    }
}
