package com.company.leetcode.E1356;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        new Solution().sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1});
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> ints = new ArrayList<>();
        for (int a : arr) {
            ints.add(a);
        }

        ints.sort((a, b) -> {
            var aa = bits(a);
            var bb = bits(b);
            if (aa > bb) return 1;
            if (aa < bb) return -1;
            return a - b;
        });
        var result = new int[ints.size()];
        for (int i = 0; i < ints.size(); i++) {
            result[i]= ints.get(i);
        }

        return result;
    }

    public int bits(int n) {
        int ans = 0;
        while (n != 0) {
            n = (n - 1) & n;
            ans += 1;
        }
        return ans;
    }
}