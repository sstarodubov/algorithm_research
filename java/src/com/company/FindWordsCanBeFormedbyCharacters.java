package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 */

public class FindWordsCanBeFormedbyCharacters {
    public static void main(String[] args) {

        var m = new  FindWordsCanBeFormedbyCharacters();

        assert 6 == m.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach");
        assert  10 == m.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr");
        System.out.println("tests passed");
    }

    // Time (n ^2 * log n) and Space O(n)
    public int countCharacters(String[] words, String chars) {
        char[] ys = chars.toCharArray();
        Arrays.sort(ys);
        ArrayList<char[]> list = new ArrayList<>();
        int ans = 0;
        for (var word : words) {
            var arr = word.toCharArray();
            Arrays.sort(arr);
            list.add(arr);
        }
        for (char[] word : list) {
            if (isEqual(word, ys)) ans += word.length;

        }
        return ans;
    }

    public boolean isEqual(char[] xs, char[] ys) {
        int xPtr = 0;
        int yPtr = 0;
        while (xPtr < xs.length) {
            if (yPtr >= ys.length) return false;
            if (xs[xPtr] == ys[yPtr]) xPtr++;
            yPtr++;
        }
        return true;
    }
}
