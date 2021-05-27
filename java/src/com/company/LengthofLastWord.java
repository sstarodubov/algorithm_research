package com.company;

public class LengthofLastWord {
    public static void main(String[] args) {

        var le = new LengthofLastWord();
        assert 3 == le.lengthOfLastWord("dfsdf dff") : 1;
        System.out.println("tests passed");
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Character.isSpaceChar(s.charAt(i))) {
                len++;
            } else return len;
        }

        return len;
    }
}
