package com.company;

public class ValidateIp {
    public static void main(String[] args) {

        assert "Neither".equals(validIPAddress("1.0.1.")) : -3;
        assert "Neither".equals(validIPAddress("1e1.4.5.6")) : -2;
        assert "Neither".equals(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")) : -1;
        assert "Neither".equals(validIPAddress("256.256.256.256")) : 0;
        assert "IPv6".equals(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")) : 1;
        assert "IPv4".equals(validIPAddress("172.16.254.1")) : 2;

        System.out.println("tests passed");
    }

    public static String validIPAddress(String IP) {
        int potential = 0;
        String[] nums = IP.split("\\.", -1);
        if (nums.length != 4) potential = 1;

        switch (potential) {
            // IP4
            case 0: {
                for (String n : nums) {
                    if (!n.matches("^\\d{1,3}$")) return "Neither";
                    if (n.charAt(0) == '0' && n.length() > 1) return "Neither";
                    int num = Integer.parseInt(n);
                    if (num > 255) return "Neither";
                }
                return "IPv4";
            }
            // IP6
            case 1: {
                String[] split = IP.split(":", -1);
                if (split.length != 8) return "Neither";
                for (String n : split) {
                    if (!n.matches("^[0-9a-fA-F]{1,4}$")) return "Neither";
                }
                return "IPv6";
            }
            default:
                return "Neither";
        }
    }
}
