package com.company;

public class AddBinary {
    public static void main(String[] args) {

        var a = new AddBinary();

        assert "11110".equals(a.addBinary("1111", "1111")) : -1;
        assert "1000".equals(a.addBinary("1", "111")) : 0;
        assert "10101".equals(a.addBinary("1010", "1011")) : 2;
        assert "100".equals(a.addBinary("11", "1")) : 1;

        System.out.println("tests passed");
    }

    public String addBinary(String a, String b) {
        var ans = new StringBuilder();
        int carry = 0;
        StringBuilder aSb = new StringBuilder(a);
        StringBuilder bSb = new StringBuilder(b);
        if (aSb.length() > bSb.length()) {
            while (aSb.length() != bSb.length()) {
                bSb.insert(0, '0');
            }
        } else if (aSb.length() < bSb.length()) {
            while (aSb.length() != bSb.length()) {
                aSb.insert(0, '0');
            }
        }

        for (int i = aSb.length() - 1; i >= 0; i--) {

            char aEl = aSb.charAt(i);
            char bEl = bSb.charAt(i);

            if (((aEl == '1' && bEl == '0') || (aEl == '0' && bEl == '1')) && carry != 0) {
                ans.insert(0, '0');
            } else if ((aEl == '1' && bEl == '0') || (bEl == '1' && aEl == '0')) ans.insert(0, '1');
            else if (aEl == '1' && bEl == '1' && carry != 0) {
                ans.insert(0, '1');
            }
            else if (aEl == '1' && bEl == '1') {
                ans.insert(0, '0');
                carry++;
            } else if (aEl == '0' && bEl == '0' && carry != 0) {
                carry--;
                ans.insert(0, '1');
            } else if (aEl == '0' && bEl == '0') ans.insert(0, '0');
        }
        if (carry != 0) {
            ans.insert(0, '1');
        }
        return ans.toString();
    }
}
