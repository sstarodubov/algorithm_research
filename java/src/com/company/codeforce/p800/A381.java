package p800;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A381 {

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var dq = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            dq.add(sc.nextInt());
        }
        int s = 0;
        int d = 0;
        boolean isSm = true;

        while (!dq.isEmpty()) {
            Integer first = dq.peekFirst();
            Integer last = dq.peekLast();

            if (isSm) {
                if (first > last) {
                    s += dq.pollFirst();
                } else {
                    s += dq.pollLast();
                }
                isSm = false;
            } else {

                if (first > last) {
                    d += dq.pollFirst();
                } else {
                    d += dq.pollLast();
                }
                isSm = true;
            }
        }

        System.out.printf("%d %d", s, d);
    }
}
