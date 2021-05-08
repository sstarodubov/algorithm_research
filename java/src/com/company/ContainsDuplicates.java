package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicates {
    public static void main(String[] args) {

        var main = new ContainsDuplicates();

        assert main.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3) : 11;
        assert !main.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);

        assert main.containsDuplicate(new int[]{1, 2, 3, 1}) : 0;
        assert !main.containsDuplicate(new int[]{1, 2, 3, 4}) : 1;

        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var t = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (t.containsKey(nums[i])) {
                int diff = Math.abs(i - t.get(nums[i]));
                if (diff <= k) return true;
            }
            t.put(nums[i], i);
        }
        return false;
    }


    // Time O(n log n) and Space O(1)
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;
        if (nums.length == 0) return false;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }
}
