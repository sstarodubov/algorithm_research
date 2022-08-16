import java.util.Scanner;

public class A1367 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        var t = sc.nextInt();
        var sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            var s = sc.next();
            sb.append(s.charAt(0));
            for (int j = 1; j < s.length(); j += 2) {
                sb.append(s.charAt(j));
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    public static int[] read(int size, final Scanner sc) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
