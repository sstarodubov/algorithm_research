package p800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DubStep {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(System.in);
        String w = sc.next();

        String result = w.replaceAll("WUB", " ")
                .replaceAll("\s+", " ")
                .trim();
        System.out.println(result);
    }
}
