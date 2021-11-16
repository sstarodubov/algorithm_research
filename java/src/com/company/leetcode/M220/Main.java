package com.company.leetcode.M220;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        assert new Solution().containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 2}, 2, 2);
        assert !new Solution().containsNearbyAlmostDuplicate(new int[]{3, -3}, 2, 4);
        assert !new Solution().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        assert new Solution().containsNearbyAlmostDuplicate(new int[]{2, 1, 1, 1}, 1, 0);
        assert new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 1, 1}, 1, 0);
        assert new Solution().containsNearbyAlmostDuplicate(new int[]{1, 9, 3, 16, 21, 2}, 2, 2);
        assert new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        assert !new Solution().containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
        System.out.println("tests passed");
    }
}


class Solution {

    // time O(n log n) and space O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1) return false;
        if (k == 0) return false;
        var tree = new TreeSet<Integer>();
        for (int i = 0; i <= k; i++) {
            if (i == nums.length) return false;
            if (tree.contains(nums[i])) return true;
            else {
                tree.add(nums[i]);
                Integer l = tree.lower(nums[i]);
                Integer h = tree.higher(nums[i]);
                if (l != null) {
                    Long tmp1 = Long.valueOf(l);
                    Long tmp2 = (long) nums[i];
                    if (Math.abs(tmp1 - tmp2) <= t) return true;
                }
                if (h != null) {
                    Long tmp1 = Long.valueOf(h);
                    Long tmp2 = (long) nums[i];
                    if (Math.abs(tmp1 - tmp2) <= t) return true;
                }

            }
        }

        for (int i = 1; i < nums.length - k; i++) {
            if (tree.size() >= k + 1) tree.remove(nums[i - 1]);
            if (tree.contains(nums[i + k])) return true;
            else {
                tree.add(nums[i + k]);
                Integer l = tree.lower(nums[i+k]);
                Integer h = tree.higher(nums[i+k]);
                if (l != null) {
                    Long tmp1 = Long.valueOf(l);
                    Long tmp2 = (long) nums[i+k];
                    if (Math.abs(tmp1 - tmp2) <= t) return true;
                }
                if (h != null) {
                    Long tmp1 = Long.valueOf(h);
                    Long tmp2 = (long) nums[i+k];
                    if (Math.abs(tmp1 - tmp2) <= t) return true;
                }

            }
        }
        return false;
    }
}