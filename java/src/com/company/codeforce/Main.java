import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();

        int t = n / m;
        int r = n % m;

        int opt = (t * b) + (a * r);
        int onlyA = a * n;
        int onlyM = (t + 1) * b;
        int res = Math.min(onlyA, Math.min(onlyM, opt));
        System.out.println(res);


    }
}
