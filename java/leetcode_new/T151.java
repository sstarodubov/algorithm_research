public class T151 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}


class Solution {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");

        var ret = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            ret.append(split[i]);
            if (i != 0) {
                ret.append(" ");
            }
        }

        return ret.toString();
    }
}
