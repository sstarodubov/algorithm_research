package com.company;

public class Atoi {
    public static void main(String[] args) {
        var a = new Atoi();
        assert Integer.MAX_VALUE == a.myAtoi("20000000000000000000") : "really big int";
        assert -2147483648 == a.myAtoi("-91283472332") : "big int";
        assert -2147483647 == a.myAtoi("-2147483647") : "low bound of big integer";
        assert 0 == a.myAtoi("   +0 123") : "+ 0123";
        assert 3 == a.myAtoi("3.14159") : "process double";
        assert -12 == a.myAtoi("  -0012a42") : " -00112a42";
        assert -42 == a.myAtoi("   -42") : "negative";
        assert 42 == a.myAtoi("42") : "positive";
        assert 0 == a.myAtoi("words and 987") : "first letter";
        assert 4193 == a.myAtoi("4193 with words") : "end word";
        assert Integer.MIN_VALUE == a.myAtoi("-20000000000000000000") : "really big negative int";
        assert 12345678 == a.myAtoi("  0000000000012345678") : "big num + a lot of 0";
        System.out.println("tests passed");
    }

    // Space O(1) and Time O(n)
    public int myAtoi(String s) {
        s = s.trim();
        boolean readMode = false;
        boolean isPositive = true;
        var out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if ((Character.isSpaceChar(letter) || letter == '0') && !readMode) continue;
            if (Character.isLetter(letter) && !readMode) return 0;
            if (letter == '-' && !readMode) {
                readMode = true;
                isPositive = false;
                continue;
            }
            if (letter == '+' && !readMode) {
                readMode = true;
                continue;
            }

            if (!Character.isDigit(letter) && readMode) break;
            if (Character.isDigit(letter)) {
                readMode = true;
                out.append(letter);
            }
        }
        if (isPositive) {
            if (out.toString().length() > 11) return Integer.MAX_VALUE;
            long tmp = Long.parseLong(out.toString());
            if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            return (int) tmp;
        }
        var negativeOut = out.insert(0, "-").toString();
        if (negativeOut.length() > 11) return Integer.MIN_VALUE;
        long tmp = Long.parseLong(negativeOut);
        if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) tmp;
    }
}