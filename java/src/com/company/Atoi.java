package com.company;

public class Atoi {
    public static void main(String[] args) {
        var a = new Atoi();
        assert -5 == a.myAtoi("-5-") : "-5-";
        assert 0 == a.myAtoi("+-12") : "+-12";
        assert 0 == a.myAtoi(".1") : ".1";
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
        int i = 0;
        int sign = 1;
        int result = 0;
        if (s.length() == 0) return 0;
        s = s.trim();
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = s.charAt(i++) == '-' ? -1 : 1;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}