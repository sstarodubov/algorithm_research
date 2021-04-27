package com.company;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        var el = new LongestIncreasingSubsequence();
        assert 4 == el.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) : 1;
        assert 4 == el.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}) : 2;
        assert 1 == el.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}) : 3;
        System.out.println("tests passed");
    }

    // Time O(n ^ 2 ) and Space O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        var lens = new int[nums.length];
        lens[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = i;
            int len = 0;
            while (cur >= 0) {
                if (nums[i] > nums[cur]) {
                    len = Math.max(len, lens[cur]);
                }
                cur--;
            }
            lens[i] = len + 1;
            ans = Math.max(lens[i], ans);
        }
        return ans;
    }
}
