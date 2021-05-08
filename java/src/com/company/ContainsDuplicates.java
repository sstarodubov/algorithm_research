package com.company;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ContainsDuplicates {
    public static void main(String[] args) {

        var main = new ContainsDuplicates();

        assert main.containsDuplicate(new int[]{1, 2, 3, 1}) : 0;
        assert !main.containsDuplicate(new int[]{1, 2, 3, 4}) : 1;

        System.out.println("tests passed");
    }


    // Time O(n) and Space O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = table.getOrDefault(nums[i], 0);
            n++;
            if (n > 1) return true;
            table.put(nums[i], n);
        }
        return false;

    }
}
