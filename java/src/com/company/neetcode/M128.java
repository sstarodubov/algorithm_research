package com.company.neetcode;

import java.util.HashMap;
import java.util.Map;

public class M128 {

    public static void main(String[] args) {
        System.out.println(new M128().longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

    static Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
    static class Result{
        int v = 0;
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], Boolean.FALSE);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (!hm.get(nums[i])) {
                var r = new Result();
                dfs(nums[i], r);
                ret = Math.max(r.v, ret);
            }
        }

        return ret;
    }

    void dfs(int cur, Result r) {
        if (!hm.containsKey(cur)) {
            return;
        }

        if (hm.get(cur)) {
            return;
        }

        r.v ++;

       hm.put(cur, Boolean.TRUE);

       dfs(cur + 1, r);
       dfs(cur - 1, r);
    }
}
