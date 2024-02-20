package org.example;

public class T58 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord(" hello world    "));
    }
}


class Solution {
    public int lengthOfLastWord(String s) {
        int ret = 0;

        int startIdx = s.length() - 1;
        while (startIdx >= 0 && Character.isSpaceChar(s.charAt(startIdx))) {
            startIdx--;
        }

        for (int i = startIdx; i >= 0; i--) {
            if (Character.isSpaceChar(s.charAt(i))) break;
            ret++;
        }
        return ret;
    }
}
