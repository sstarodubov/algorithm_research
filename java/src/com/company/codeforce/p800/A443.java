package p800;

import java.util.HashSet;
import java.util.Scanner;

public class A443 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("");
        var set = new HashSet<String>();
        while (scan.hasNext()) {
            String el = scan.next();
            if (el.isBlank()) continue;
            if (el.equals(",")) continue;
            if (el.equals("}") || el.equals("{")) continue;
            set.add(el);
        }

        System.out.println(set.size());
    }
}
