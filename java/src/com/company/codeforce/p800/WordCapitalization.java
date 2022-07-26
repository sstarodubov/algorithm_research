package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordCapitalization {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));
        char first = (char) in.read();
        var sb = new StringBuilder();
        sb.append(Character.toUpperCase(first));
        while (in.ready()) {
            char cur = (char) in.read();
            sb.append(cur);
        }

        System.out.println(sb);
    }
}
