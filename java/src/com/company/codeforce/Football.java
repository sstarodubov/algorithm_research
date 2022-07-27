import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Football {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        int p;
        int counter = 1;
        int prev = -1000;
        while ((p = in.read()) != -1) {
            if (p == prev) counter++;
            else counter = 1;
            prev = p;
            if (counter == 7) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
