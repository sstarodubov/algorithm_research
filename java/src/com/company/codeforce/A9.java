import java.util.Scanner;

public class A9 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int w = sc.nextInt();
        int j = Math.max(y, w);

        String ans = switch (j) {
            case 1 -> "1/1";
            case 2 -> "5/6";
            case 3 -> "2/3";
            case 4 -> "1/2";
            case 5 -> "1/3";
            case 6 -> "1/6";
            default -> throw new IllegalStateException("Unexpected value: " + j);
        };

        System.out.println(ans);
    }
}
