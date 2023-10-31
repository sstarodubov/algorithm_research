import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = sc.nextDouble();
        var m = sc.nextDouble();
        var a = sc.nextDouble();

        long nn = (long) (Math.ceil(n / a));
        long mm = (long) (Math.ceil(m / a));

        System.out.println(nn * mm);
    }
}
