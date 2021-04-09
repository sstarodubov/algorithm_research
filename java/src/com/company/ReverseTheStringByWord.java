package com.company;

public class ReverseTheStringByWord {

    public static void main(String[] args) {
        assert  "blue is sky the".equals(reverseWords("the sky is blue")) : "1";
        assert  "world hello".equals(reverseWords("   hello world   ")) : "2";
        assert  "Alive Loves Bob".equals(reverseWords("  Bob    Loves  Alice   ")) : "3";
        assert  "bob like even not does Alice".equals(reverseWords("Alice does not even like bob")) : "4";
        System.out.println("tests passed");
    }

    public static String reverseWords(String s) {
        return null;
    }
}
