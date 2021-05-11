package com.company;

public class DefanginganIPAddress {
    public static void main(String[] args) {
        var m = new DefanginganIPAddress();
        assert "1[.]1[.]1[.]1".equals(m.defangIPaddr("1.1.1.1")) : 1;

        System.out.println("tests passed");
    }


    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') ans.append(address.charAt(i));
            else {
                ans.append('[');
                ans.append('.');
                ans.append(']');
            }
        }
        return ans.toString();
    }
}
