package com.company.leetcode.E1720;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        assert Arrays.equals(new Solution().decode(new int[]{1, 2, 3}, 1), new int[]{1, 0, 2, 1});
        System.out.println("tests passed");
    }
}


class Solution {
    public int[] decode(int[] encoded, int first) {

        var ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }
}
