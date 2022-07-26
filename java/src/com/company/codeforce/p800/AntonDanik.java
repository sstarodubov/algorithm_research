import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AntonDanik {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int d = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') a++;
            else d++;
        }

        if (a == d) System.out.println("Friendship");
        else if (a > d) System.out.println("Anton");
        else System.out.println("Danik");
    }
}
