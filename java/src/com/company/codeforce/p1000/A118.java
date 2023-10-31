package p1000;

import java.util.Scanner;

public class A118 {

    static char[] arr = new char[]{'a', 'o', 'y', 'e', 'u', 'i'};

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var s = sc.nextLine();
        var sb = new StringBuilder();
        char t;
        for (int i = 0; i < s.length(); i++) {
            t = Character.toLowerCase(s.charAt(i));
            if (!contains(t)) {
                sb.append('.').append(t);
            }
        }

        System.out.println(sb);
    }

    public static boolean contains(char a) {
        for (char c : arr) {
            if (c == a) return true;
        }
        return false;
    }
}
