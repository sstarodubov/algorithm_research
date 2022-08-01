import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class CaseoftheZerosandOnes {


    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        int cur;
        var stack = new ArrayDeque<Character>();
        var n = sc.nextInt();
        var s = sc.next();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) stack.push(ch);
            else {
                var p = stack.peek();
                if ((p == '1' && ch == '0') || (p == '0' && ch == '1')) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        System.out.println(stack.size());
    }
}


