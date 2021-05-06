package com.company;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        var m = new ValidAnagram();

        assert m.isAnagram("anagram", "nagaram") : 0;
        assert !m.isAnagram("rat", "car") : 1;
        assert !m.isAnagram("a", "ab");
        System.out.println("tests passed");
    }
    // Time O(n * log n) and Space O(n)
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        if (arrS.length != arrT.length) return false;
        Arrays.parallelSort(arrS);
        Arrays.parallelSort(arrT);
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] != arrT[i]) return false;
        }
        return true;
    }
}
