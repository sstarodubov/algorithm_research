package com.company;

public class CheckIfTwoStringArraysareEquivalent {
    public static void main(String[] args) {

        var checker = new CheckIfTwoStringArraysareEquivalent();
        assert checker.arrayStringsAreEqual(new String[]{"a", "bc"}, new String[]{"ab", "c"}) : 1;

        System.out.println("tests passed");
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        for (var s : word1) {
            sb1.append(s);
        }

        for (var s : word2) {
            sb2.append(s);
        }
        if (sb1.length() != sb2.length()) return false;
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }
}
