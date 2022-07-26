package p800;

import java.util.Scanner;

public class QueueAtSchool {
    public static void main(String[] args) throws Exception {
        var in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        char[] children = in.next().toCharArray();
        for (int i = 0; i < t; i++) {
            int idx = 1;
            while (idx < n) {
                char prev = children[idx - 1];
                char cur = children[idx];
                if (prev == 'B' && cur == 'G') {
                    children[idx - 1] = 'G';
                    children[idx] = 'B';
                    idx += 2;
                } else {
                    idx++;
                }
            }
        }
        System.out.println(new String(children));
    }
}
