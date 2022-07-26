package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Word {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        String w = in.readLine();
        int up = 0;
        int low = 0;
        for (int i = 0; i < w.length(); i++) {
            if (Character.isUpperCase(w.charAt(i))) up++;
            else low++;
        }

        if (low >= up) {
            System.out.println(w.toLowerCase());
        } else {
            System.out.println(w.toUpperCase());
        }
    }
}
