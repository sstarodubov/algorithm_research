package com.company.leetcode.E217;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        assert new Solution().containsDuplicate(new int[]{1, 2, 3, 1});
        assert !new Solution().containsDuplicate(new int[]{1, 2, 3});
        System.out.println("tests passed");
    }
}


class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set= new HashSet<>();
        for (var num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
}