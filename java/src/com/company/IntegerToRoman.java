package com.company;

public class IntegerToRoman {
    public static void main(String[] args) {

        var m = new IntegerToRoman();

        assert "MM".equals(m.intToRoman(2000)) : 2000;
        assert "MCMXCIV".equals(m.intToRoman(1994)) : 1994;
        assert "LXXXV".equals(m.intToRoman(85)) : 85;
        assert "LVIII".equals(m.intToRoman(58)) : 58;
        assert "XLV".equals(m.intToRoman(45)) : 45;
        assert "IX".equals(m.intToRoman(9)) : 9;
        assert "III".equals(m.intToRoman(3)) : 3;
        assert "IV".equals(m.intToRoman(4)) : 4;
        System.out.println("tests passed");
    }

    public String intToRoman(int num) {
        int devider = 10;
        StringBuilder letter = new StringBuilder();
        while (num != 0) {
            int n = num % devider;
            if (n < 10) {
                if (n == 4) letter.append("IV");
                else if (n == 9) letter.append("IX");
                else if (n == 5) letter.append("V");
                else if (n < 5) {
                    letter.append("I".repeat(Math.max(0, n)));
                } else {
                    letter.append("V");
                    letter.append("I".repeat(n - 5));
                }
            } else if (n == 10) letter.insert(0, "X");
            else if (n < 50) {
                if (n == 40) letter.insert(0, "XL");
                else {
                    for (int j = 0; j < n / 10; j++) {
                        letter.insert(0, "X");
                    }
                }
            } else if (n == 50) letter.insert(0, "L");
            else if (n < 100) {
                if (n == 90) letter.insert(0, "XC");
                else if (n < 90) {
                    letter.insert(0, "L");
                    for (int j = 0; j < (n / 10) - 5; j++) {
                        letter.insert(1, "X");
                    }
                }
            } else if (n == 100) letter.insert(0, "C");
            else if (n == 500) letter.insert(0, "D");
            else if (n == 400) letter.insert(0, "CD");
            else if (n < 400) {
                for (int j = 0; j < n / 100; j++) {
                    letter.insert(0, "C");
                }
            } else if (n == 1000) letter.insert(0, "M");
            else if (n == 900) letter.insert(0, "CM");
            else if (n < 900) {
                letter.insert(0, "D");
                for (int j = 0; j < (n / 100) - 5; j++) {
                    letter.insert(1, "C");
                }
            } else if (n > 1000) {
                for (int j = 0; j < (n / 1000); j++) {
                    letter.insert(0, "M");
                }
            }

            //
            num -= n;
            devider *= 10;
        }

        return letter.toString();
    }
}
