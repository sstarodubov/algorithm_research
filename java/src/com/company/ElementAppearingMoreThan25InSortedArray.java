package com.company;

/*
Given an integer array sorted in non-decreasing order
, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 */
public class ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {


        assert 6 == findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}) : 0;
        assert 1 == findSpecialInteger(new int[]{1, 1}) : 1;
        System.out.println("tests passed");
    }

    public static int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];
        int ptc = arr.length >> 2;
        int ans = 0;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count >= ptc) return arr[i];
            } else {
                ans = Math.max(count, ans);
                count = 0;
            }
        }
        return ans;
    }
}
