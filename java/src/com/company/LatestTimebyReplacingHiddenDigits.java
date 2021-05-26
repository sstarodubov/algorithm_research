package com.company;

public class LatestTimebyReplacingHiddenDigits {
    public static void main(String[] args) {
        var latest = new LatestTimebyReplacingHiddenDigits();
        assert "23:39".equals(latest.maximumTime("?3:39")) : 4;
        assert "23:50".equals(latest.maximumTime("2?:?0")) : 1;
        assert "09:39".equals(latest.maximumTime("0?:3?")) : 2;
        assert "19:22".equals(latest.maximumTime("1?:22")) : 3;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        if (chars[0] == '?' && chars[1] == '?') {
            chars[0] = '2';
            chars[1] = '3';
        } else {
            if (chars[0] == '?') {
                if (chars[1] <= '3') chars[0] = '2';
                else chars[0] = '1';
            }

            if (chars[1] == '?') {
                if (chars[0] == '2') chars[1] = '3';
                else chars[1] = '9';
            }
        }

        if (chars[3] == '?') {
            chars[3] = '5';
        }

        if (chars[4] == '?') {
            chars[4] = '9';
        }

        var str = new StringBuilder();
        for (var c : chars) {
            str.append(c);
        }
        return str.toString();
    }
}
