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

    // Time (n ^2) and Space O(n)
    public int countCharacters(String[] words, String chars) {
        char[] count = new char[26];
        int goodStrings = 0;
        chars.chars().forEach(ch -> ++count[ch-'a']);

        for(String word : words){
            if(isGoodString(word, count)){
                goodStrings += word.length();
            }
        }
        return goodStrings;
    }

    public boolean isGoodString(String word, char[] count){
        char[] currCount = new char[26];

        for(char ch : word.toCharArray()){
            currCount[ch-'a']++;
            if(currCount[ch-'a'] > count[ch-'a']){
                return false;
            }
        }
        return true;
    }
}
