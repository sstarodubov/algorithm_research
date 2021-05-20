package com.company;

/*
Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

 */
public class NumArray {

    final int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }


    public static void main(String[] args) {
        var n = new NumArray(new int[]{1, 2, 3, 4, 5});

        assert 12 == n.sumRange(2, 4);
        assert 1 == n.sumRange(0, 0);

        System.out.println("tests passed");
    }
}
