package com.company;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {

        var inc = new MedianofTwoSortedArrays();

        assert 1.0 == inc.findMedianSortedArrays(new int[]{}, new int[]{1}) : 3;
        assert 2.0 == inc.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) : 0;
        assert 2.0 == inc.findMedianSortedArrays(new int[]{2}, new int[]{}) : 4;
        assert 2.5 == inc.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) : 1;
        assert 0.0 == inc.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}) : 2;
        assert 2.5 == inc.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}) : 10;
        System.out.println("tests passed");
    }
    // Time O(n) and Space O(n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var merged = new int[nums1.length + nums2.length];
        if (nums1.length == 0) return findMedian(nums2);
        if (nums2.length == 0) return findMedian(nums1);

        int l = 0, r = 0, cur = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] < nums2[r]) {
                merged[cur] = nums1[l];
                cur++;
                l++;
                continue;
            }
            merged[cur] = nums2[r];
            r++;
            cur++;
        }

        while (r < nums2.length) {
            merged[cur] = nums2[r];
            r++;
            cur++;
        }
        while (l < nums1.length) {
            merged[cur] = nums1[l];
            cur++;
            l++;
        }

        return findMedian(merged);
    }

    public double findMedian(int[] nums) {
        if (nums.length == 0) return 0.0;
        if (nums.length == 1) return nums[0];

        int idx = nums.length / 2;
        if ((nums.length & 1) == 1) return nums[idx];
        return ((double) nums[idx] + (double) nums[idx - 1]) / 2;
    }
}
