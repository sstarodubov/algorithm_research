package p800;

import java.util.HashMap;
import java.util.Scanner;

public class Keyboard {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        var keybord = "qwertyuiopasdfghjkl;zxcvbnm,./";
        var cm = new HashMap<Character, Integer>();

        for (int i = 0; i < keybord.length(); i++) {
            cm.put(keybord.charAt(i), i);
        }

        var d = sc.next();
        var s = sc.next();

        var ans = new StringBuilder();

        if (d.equals("R")) {
            for (int i = 0; i < s.length(); i++) {
                var typed = s.charAt(i);
                var wanted = (keybord.charAt((cm.get(typed) - 1)));
                ans.append(wanted);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                var typed = s.charAt(i);
                var wanted = (keybord.charAt((cm.get(typed) + 1)));
                ans.append(wanted);
            }
        }
        System.out.println(ans);
    }
}
