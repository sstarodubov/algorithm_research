package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TableStones {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(in.readLine());
        char prev = 'j';
        for (int i = 0; i < n; i++) {
            char cur = (char) in.read();
            if (cur == prev) ans++;
            else prev = cur;
        }
        System.out.println(ans);
    }
}
