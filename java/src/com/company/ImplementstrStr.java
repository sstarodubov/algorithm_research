package com.company;

public class ImplementstrStr {
    public static void main(String[] args) {
        var m = new ImplementstrStr();

        assert 3 == m.strStr("hello", "lo") : -1000;
        assert 4 == m.strStr("mississippi", "issip") : -106;
        assert -1 == m.strStr("aa", "aaaaa") : -105;
        assert 0 == m.strStr("aaa", "aaa") : -104;
        assert -1 == m.strStr("", "he") : -103;
        assert 0 == m.strStr("hello", "he") : -101;
        assert -1 == m.strStr("hello", "oo") : -101;
        assert 4 == m.strStr("hello", "o") : -100;
        assert 0 == m.strStr("hello", "h") : -200;
        assert 2 == m.strStr("hello", "ll") : 22;
        assert 0 == m.strStr("", "") : 1;
        assert -1 == m.strStr("aaaa", "baa") : -1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int ptrH = 0;
        int ptrN = 0;
        boolean reading = false;
        int r = 0;
        while (ptrH < haystack.length()) {
            char hL = haystack.charAt(ptrH);
            char nL = needle.charAt(ptrN);
            if (hL != nL && !reading) {
                ptrH++;
            } else if (hL != nL) {
                ptrH = r;
                ptrN = 0;
                reading = false;
            } else {
                if (!reading) r = ptrH + 1;
                reading = true;
                if (needle.length() == 1) return ptrH;
                ptrH++;
                ptrN++;
            }
            if (ptrN >= needle.length()) return ptrH - ptrN;
        }
        return -1;
    }
}
