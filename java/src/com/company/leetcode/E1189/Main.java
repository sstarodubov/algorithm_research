package com.company.leetcode.E1189;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        assert new Solution().maxNumberOfBalloons("loonbalxballpoon") == 2;
        System.out.println("tests passed");
    }
}


class Solution {
    public int maxNumberOfBalloons(String text) {
        var map = new HashMap<>(
                Map.of('b', 0,
                        'a', 0,
                        'l', 0,
                        'o', 0,
                        'n', 0));
        for (int i = 0; i < text.length(); i++) {
            map.computeIfPresent(text.charAt(i), (k, v) -> v + 1);
        }
        int ans = Integer.MAX_VALUE;

        for (var ent : map.entrySet()) {
            int cur;
            if (ent.getKey() == 'o' || ent.getKey() == 'l') {
                cur = ent.getValue() / 2;
            } else {
                cur = ent.getValue();
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}