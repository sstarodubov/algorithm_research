package com.company;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingArray {
    public static void main(String[] args) {
        var a = new StringMatchingArray();

        List<String> words = a.stringMatching(new String[]{"mass", "as", "hero", "superhero"});
        assert words.get(0).equals("as") : 1;
        assert words.get(1).equals("hero") : 2;


        List<String> strings = a.stringMatching(new String[]{"leetcode", "et", "code"});
        assert strings.get(0).equals("et") : 3;
        assert strings.get(1).equals("code") : 4;

        List<String> strings1 = a.stringMatching(new String[]{"blue", "green", "bu"});
        assert strings1.size() == 0 : 5;

        System.out.println("tests passed");
    }

    // Time O(n^2) and Space O(n)
    public List<String> stringMatching(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (str.indexOf(word) != str.lastIndexOf(word)) {
                res.add(word);
            }
        }
        return res;
    }
}
