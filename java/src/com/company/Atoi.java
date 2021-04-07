package com.company;

public class Atoi {
    public static void main(String[] args) {
        var a = new Atoi();
        assert -2147483647 == a.myAtoi("-2147483647"): "low bound of big integer";
        assert 42 == a.myAtoi("42") : "positive";
        assert 0 == a.myAtoi("words and 987") : "first letter";
        assert -42 == a.myAtoi("   -42") : "negative";
        assert 4193 == a.myAtoi("4193 with words") : "end word";
        assert -2147483648 == a.myAtoi("-91283472332") : "big int";
        assert 3 == a.myAtoi("3.14159") : "process double";
        assert -12 == a.myAtoi("  -0012a42") : " - 00112a42";
        assert 0 == a.myAtoi("   +0 123") : "+ 0123";
        assert Integer.MAX_VALUE == a.myAtoi("20000000000000000000") : "really big int";
        assert Integer.MIN_VALUE == a.myAtoi("-20000000000000000000") : "really big negative int";
        assert 12345678 == a.myAtoi("  0000000000012345678") : "big num + a lot of 0";
        System.out.println("tests passed");
    }

    public int myAtoi(String s) {
        if (!s.matches("^\\s*([+\\-])?\\d+\\.?\\d*[a-zA-Z\\s0-9\\-]*")) return 0;
        boolean started = true;
        String[] ar = s.split("");
        var out = new StringBuilder();
        for (String a : ar) {
            if (a.matches("\\s") && started) continue;
            if (!a.matches("[a-zA-Z\\s]")) {
                out.append(a);
                started = false;
            } else break;
        }
        if (out.toString().contains(".")) {
            var r = new StringBuilder();
            for (var a : out.toString().split("")) {
                if (a.equals(".")) {
                    out = r;
                    break;
                } else r.append(a);
            }
        }
        boolean isNegative = out.toString().contains("-");
        var r = out.toString().replaceAll("^[\\s*0+-]+", "0").replaceAll("-$", "");
        if (r.length() > 11) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        long lnum = Long.parseLong(isNegative ? "-" + r : r);
        if (lnum < Integer.MIN_VALUE) return  Integer.MIN_VALUE;
        if (lnum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) lnum;
    }
}