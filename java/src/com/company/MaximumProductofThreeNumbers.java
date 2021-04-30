package com.company;

import java.util.Arrays;

/**
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 */
public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {

        var m = new MaximumProductofThreeNumbers();

        assert -6 == m.maximumProduct(new int[] {-1, -2 , -3}) : 0;
        assert 39200 == m.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}) : 2;
        assert 60 == m.maximumProduct(new int[]{2, 3, 4, 5}) : 1;
        assert -6 == m.maximumProduct(new int[]{-1, -2, -3, -4}) : 33;
        System.out.println("tests passed");
    }

    // O Time(n * log n ) and Space O(1)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length - 1];
        int attL = nums[0] * nums[1];
        int attR = nums[nums.length - 2] * nums[nums.length - 3];
        if (last < 0) return last * attR;
        return attL > attR ? attL * last : attR * last;
    }
}

