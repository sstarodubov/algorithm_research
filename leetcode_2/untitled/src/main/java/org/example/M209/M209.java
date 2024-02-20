package org.example.M209;

public class M209 {
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(1, new int[]{1,1,1,1,1}));
    }
}


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int lt = 0, rt = 0, cur = nums[0], ret = Integer.MAX_VALUE;
        while (lt < nums.length && rt < nums.length) {
            if (cur >= target) {
                ret = Math.min(ret, rt - lt + 1);
                if (lt >= nums.length) break;
                cur -= nums[lt];
                lt++;
            } else {
                rt++;
                if (rt >= nums.length) break;
                cur += nums[rt];
            }
        }

        while (lt < nums.length) {
            if (cur >= target) {
                ret = Math.min(ret, rt - lt + 1);
            }
            cur -= nums[lt];
            lt++;
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
