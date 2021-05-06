package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class MakingFileNamesUnique {

    public static void main(String[] args) {
        var m = new MakingFileNamesUnique();
        assert Arrays.equals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"}, m.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}));
        System.out.println("tests passed");
    }

    // Time O(n ^2 ) and Space O(n)
    public String[] getFolderNames(String[] names) {

        var table = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            if (!table.containsKey(names[i])) table.put(names[i], 0);
            else {
                int n = 1;
                while (true) {
                    String newKey = names[i] + "(" + n + ")";
                    if (!table.containsKey(newKey)) {
                        table.put(newKey, 0);
                        names[i] = newKey;
                        break;
                    }
                    n++;
                }
            }
        }
        return names;
    }
}