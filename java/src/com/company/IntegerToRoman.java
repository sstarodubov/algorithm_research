package com.company;

import java.util.ArrayList;

public class IntegerToRoman {
    public static void main(String[] args) {

        var m = new IntegerToRoman();

        assert "MM".equals(m.intToRoman(2000));
        assert "MCMXCIV".equals(m.intToRoman(1994));
        assert "LXXXV".equals(m.intToRoman(85));
        assert "LVIII".equals(m.intToRoman(58));
        assert "XLV".equals(m.intToRoman(45));
        assert "IX".equals(m.intToRoman(9));
        assert "III".equals(m.intToRoman(3));
        assert "IV".equals(m.intToRoman(4));
        System.out.println("tests passed");
    }

    public String intToRoman(int num) {
        var buffer = new ArrayList<Integer>();
        int devider = 10;
        while (num != 0) {
            int d = num % devider;

            buffer.add(d);

            num -= d;
            devider *= 10;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < buffer.size(); i++) {
            int n = buffer.get(i);
            String letter = "";
            if (n < 10) {
                if (n == 4) letter = "IV";
                else if (n == 9) letter = "IX";
                else if (n == 5) letter = "V";
                else if (n < 5) {
                    for (int j = 0; j < n; j++) {
                        letter += "I";
                    }
                } else {
                    letter = "V";
                    for (int j = 0; j < n - 5; j++) {
                        letter += "I";
                    }
                }
            } else if (n == 10) letter = "X";
            else if (n < 50) {
                if (n == 40) letter = "XL";
                else {
                    for (int j = 0; j < n / 10; j++) {
                        letter += "X";
                    }
                }
            } else if (n == 50) letter = "L";
            else if (n < 100) {
                if (n == 90) letter = "XC";
                else if (n < 90) {
                    letter = "L";
                    for (int j = 0; j < (n / 10) - 5; j++) {
                        letter += "X";
                    }
                }
            } else if (n == 100) letter = "C";
            else if (n == 500) letter = "D";
            else if (n == 400) letter = "CD";
            else if (n < 400) {
                for (int j = 0; j < n / 100; j++) {
                    letter += "C";
                }
            } else if (n == 1000) letter = "M";
            else if (n == 900) letter = "CM";
            else if (n < 900) {
                letter = "D";
                for (int j = 0; j < (n / 100) - 5; j++) {
                    letter += "C";
                }
            } else if (n > 1000) {
                for (int j = 0; j < (n / 1000); j++) {
                    letter+= "M";
                }
            }
            ans.insert(0, letter);
        }
        return ans.toString();
    }
}
