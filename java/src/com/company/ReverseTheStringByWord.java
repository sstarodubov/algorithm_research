package com.company;

public class ReverseTheStringByWord {

    public static void main(String[] args) {
        assert "Alice Loves Bob".equals(reverseWords("  Bob    Loves  Alice   ")) : "3";
        assert "bob like even not does Alice".equals(reverseWords("Alice does not even like bob")) : "4";
        assert "blue is sky the".equals(reverseWords("the sky is blue")) : "1";
        assert "world hello".equals(reverseWords("   hello world   ")) : "2";
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public static String reverseWords(String s) {
        s = s.trim();
        var arr = s.split("\\s+");
        var out = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i != 0 && i != arr.length - 1) out.append(" ").append(arr[i]);
            else if (i == arr.length - 1) out.append(arr[i]);
            else out.append(" ").append(arr[i]);
        }
        return out.toString();
    }
}
