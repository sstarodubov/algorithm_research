import java.util.Scanner;

public class PetyaStrings {
    public static void main(String[] args)  {
        var sc = new Scanner(System.in);

        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();

        for (int i = 0; i < s1.length(); i++) {

            if (s2.charAt(i) == s1.charAt(i)) continue;
            if (s1.charAt(i) < s2.charAt(i)) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
            return;
        }
        System.out.println(0);
    }
}
