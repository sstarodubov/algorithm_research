package p800;

import java.util.Scanner;

public class B32 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        var s = sc.next();
        int pt = 0;
        var sb = new StringBuilder();

        while (pt < s.length()) {
            if (s.charAt(pt) == '.') {
                sb.append("0");
                pt++;
            } else if (s.charAt(pt) == '-' && s.charAt(pt + 1) == '.') {
                sb.append("1");
                pt += 2;
            } else if (s.charAt(pt) == '-' && s.charAt(pt + 1) == '-') {
                sb.append("2");
                pt += 2;
            }
        }
        System.out.println(sb);
    }
}
