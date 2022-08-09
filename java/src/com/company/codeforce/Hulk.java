import java.util.Scanner;

public class Hulk {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        int n = sc.nextInt();

        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sb.append("I hate ");
            } else {
                if ((i & 1) == 0) {
                    sb.append("that I love ");
                } else {
                    sb.append("that I hate ");
                }
            }
        }
        sb.append("it");
        System.out.println(sb);
    }
}
