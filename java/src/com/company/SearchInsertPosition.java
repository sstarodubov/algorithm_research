package com.company;

public class SearchInsertPosition {
    public static void main(String[] args) {
        var s = new SearchInsertPosition();

        assert 1 == s.searchInsert(new int[]{1}, 2) : -1002;
        assert 0 == s.searchInsert(new int[]{1}, 0) : -1002;
        assert 1 == s.searchInsert(new int[]{2, 4, 5, 6}, 3) : -1001;
        assert 0 == s.searchInsert(new int[]{2, 3, 4, 5}, 1) : -1000;
        assert 4 == s.searchInsert(new int[]{1, 3, 5, 6}, 7) : 10;
        assert 1 == s.searchInsert(new int[]{1, 3, 5, 6}, 3) : 110;
        assert 2 == s.searchInsert(new int[]{1, 3, 5, 6}, 5) : 2;
        assert 3 == s.searchInsert(new int[]{1, 3, 5, 6}, 6) : 2;
        assert 0 == s.searchInsert(new int[]{1, 3, 5, 6}, 1) : 2;
        assert 2 == s.searchInsert(new int[]{1, 3, 5, 6}, 5) : 1000;

        System.out.println("tests passed");
    }

    // Time O(log n) and Space O(1)
    public int searchInsert(int[] nums, int target) {
        int lPtr = 0;
        int rPtr = nums.length - 1;
        int idx = (lPtr + rPtr) / 2;

        while (lPtr + 1 != rPtr && lPtr != rPtr) {
            if (nums[idx] == target) return idx;
            if (target < nums[idx]) {
                rPtr = idx;
            } else if (target > nums[idx]) {
                lPtr = idx;
            }
            idx = (lPtr + rPtr) / 2;
        }

        if (target == nums[lPtr]) return lPtr;
        if (target == nums[rPtr]) return rPtr;
        if (target > nums[lPtr] && target < nums[rPtr]) return lPtr + 1;
        if (target > nums[rPtr]) return nums.length;
        if (target < nums[lPtr]) return 0;
        else return -1;
    }
}
