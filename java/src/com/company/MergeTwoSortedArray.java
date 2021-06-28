package com.company;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        var a = new int[] {1,2,3,0,0,0};
        merge(a , 3, new int[]{2,5,6}, 3);
        System.out.println("tests passed");
    }

    // Time O(n + m) and Space O(m)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums1[i];
        }

        int l = 0, r = 0, i = 0;
        while (true) {
            if (l >= arr.length) {
                while (r < nums2.length) {
                    nums1[i] = nums2[r];
                    r++;
                    i++;
                }
                return;
            }

            if (r >= nums2.length) {
                while (l < arr.length) {
                    nums1[i] = arr[l];
                    l++;
                    i++;
                }
                return;
            }

            if (arr[l] > nums2[r]) {
                nums1[i] = nums2[r];
                r++;
            } else {
                nums1[i] = arr[l];
                l++;
            }
            i++;
        }
    }
}
