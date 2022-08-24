import java.util.Scanner;

public class A431 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
        var s = sc.next();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = Character.getNumericValue(s.charAt(i));
            ans += arr[j - 1];
        }

        System.out.println(ans);
    }
}
