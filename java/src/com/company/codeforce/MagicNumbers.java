import java.util.Scanner;

public class MagicNumbers {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        var str = sc.next();
        while (str.length() > 0) {
            if (str.endsWith("144")) {
                str = str.substring(0, str.length() - 3);
            } else if (str.endsWith("14")) {
                str = str.substring(0, str.length() - 2);
            } else if (str.endsWith("1")) {
                str = str.substring(0, str.length() - 1);
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
