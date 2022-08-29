import java.util.Scanner;

public class A492 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 1;
        int r = 0;
        int all = 0;
        for (int i = 1; all <= n; i+= s) {
            s++;
            all += i;
            r++;
        }
        System.out.println(r - 1);
    }
}