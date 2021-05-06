package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class MakingFileNamesUnique {

    public static void main(String[] args) {
        var m = new MakingFileNamesUnique();
        assert Arrays.equals(new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"}, m.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}));
        System.out.println("tests passed");
    }

    // Time O(n ^2 ) and Space O(n)
    public String[] getFolderNames(String[] names) {
        var table = new LinkedHashMap<String, Integer>();
        for (var name : names) {
            if (!table.containsKey(name)) table.put(name, 0);
            else {
                int n = 1;
                while (true) {
                    String newKey = name + "(" + n + ")";
                    if (!table.containsKey(newKey)) {
                        table.put(newKey, 0);
                        break;
                    }
                    n++;
                }
            }
        }
        return table.keySet().toArray(new String[0]);
    }
}
