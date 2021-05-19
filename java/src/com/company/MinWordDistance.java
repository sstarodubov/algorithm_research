package com.company;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

 */
public class MinWordDistance {
    public static void main(String[] args) {

        assert 3 == minDistance("honda", "hyundai") : 1;
        System.out.println("tests passed");
    }
    // Time O(n^2) and Space O(n^2)
    public static int minDistance(String word1, String word2) {
        word1 = " " + word1;
        word2 = " " + word2;
        int[][] mxt = new int[word1.length()][word2.length()];
        for (int i = 0; i < mxt.length; i++) {
            mxt[i][0] = i;
        }
        for (int i = 0; i < mxt[0].length; i++) {
            mxt[0][i] = i;
        }

        for (int i = 1; i < mxt.length; i++) {
            char letter1 = word1.charAt(i);
            for (int j = 1; j < mxt[i].length; j++) {
                char letter2 = word2.charAt(j);
                if (letter2 == letter1) {
                    mxt[i][j] = mxt[i - 1][j - 1];
                } else {
                    int min = Math.min(mxt[i][j - 1], mxt[i - 1][j]);
                    min = Math.min(min, mxt[i - 1][j - 1]);
                    mxt[i][j] = min + 1;
                }
            }
        }
        return mxt[mxt.length - 1][mxt[0].length - 1];
    }
}
