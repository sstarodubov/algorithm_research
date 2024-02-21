package org.example.E383;

import java.util.HashMap;

public class E383 {
    public static void main(String[] args) {
    }
}


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var map = new HashMap<Character, Integer>() ;
        for (int i = 0; i < magazine.length(); i++) {
           var cur = map.getOrDefault(magazine.charAt(i), 0);
           map.put(magazine.charAt(i), cur + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            var count = map.getOrDefault(ransomNote.charAt(i), 0);
            if (count <= 0 ) return false;
            map.put(ransomNote.charAt(i), count - 1);
        }
        return true;
    }
}
