package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ContainsDuplicates {
    public static void main(String[] args) {

        var main = new ContainsDuplicates();

        assert main.containsDuplicate(new int[]{1, 2, 3, 1}) : 0;
        assert !main.containsDuplicate(new int[]{1, 2, 3, 4}) : 1;

        System.out.println("tests passed");
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
