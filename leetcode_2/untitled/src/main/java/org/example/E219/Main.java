package org.example.E219;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1}, 1));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var win = new HashSet<Integer>();
        int i = 0;
        while (i <= k) {
            if (i >= nums.length) return false;
            if (win.contains(nums[i])) {
                return true;
            }
            win.add(nums[i]);
            i++;
        }

        int lt = 0, rt = i - 1;

        for (int j = i; j < nums.length; j++) {
            win.remove(nums[lt]);
            if (win.contains(nums[j])) {
                return true;
            }
            win.add(nums[j]);
            lt++;
            rt++;
        }
        return false;
    }
}
