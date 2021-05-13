package com.company;

public class RomanToInteger {
    public static void main(String[] args) {

        var m = new RomanToInteger();
        assert 500 == m.romanToInt("D"): 500;
        assert 1994 == m.romanToInt("MCMXCIV") : 1994;
        assert 58 == m.romanToInt("LVIII") : 58;
        assert 3 == m.romanToInt("III") : 0;
        assert 4 == m.romanToInt("IV") : 1;
        assert 9 == m.romanToInt("IX") : 9;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public int romanToInt(String s) {
        if (s.length() == 1) {
            char first = s.charAt(0);
            if (first == 'I') return  1;
            else if (first == 'V') return 5;
            else if (first == 'X') return 10;
            else if (first == 'L') return 50;
            else if (first == 'C') return 100;
            else if (first == 'D') return 500;
            else if (first == 'M') return 1000;
        }
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i - 1);
            int next = s.charAt(i);
            int val = 0;
            if (cur == 'I' && (next == 'V' || next == 'X')) val = -1;
            else if (cur == 'I') val = 1;
            else if (cur == 'V') val = 5;
            else if (cur == 'X' && (next == 'L' || next == 'C')) val = -10;
            else if (cur == 'X') val = 10;
            else if (cur == 'C' && (next == 'D' || next == 'M')) val = -100;
            else if (cur == 'L') val = 50;
            else if (cur == 'C') val = 100;
            else if (cur == 'D') val = 500;
            else if (cur == 'M') val = 1000;
            ans += val;
            if (i == s.length() - 1) {
                if (next == 'I') val = 1;
                else if (next == 'V') val = 5;
                else if (next == 'X') val = 10;
                else if (next == 'L') val = 50;
                else if (next == 'C') val = 100;
                else if (next == 'D') val = 500;
                else if (next == 'M') val = 1000;
                ans += val;
            }
        }
        return ans;
    }
}
