package com.company.leetcode.E26;

public class Main {
    public static void main(String[] args) {
        assert new Solution().removeDuplicates(new int[]{1, 2}) == 2;
        assert new Solution().removeDuplicates(new int[]{1, 2, 2, 3, 4, 4}) == 4;
        assert new Solution().removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 4, 4,}) == 4;
        assert new Solution().removeDuplicates(new int[]{1, 1, 2}) == 2;
        System.out.println("tests passed");
    }
}


class Solution {

    //time O(n) , space O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int writePtr = 0;
        while (nums[writePtr + 1] != nums[writePtr]) {
            writePtr++;
            if (writePtr == nums.length - 1) return nums.length;
        }
        int readPtr = writePtr + 1;

        while (readPtr < nums.length) {
            if (isUniq(readPtr, nums)) {
                nums[writePtr] = nums[readPtr];
                writePtr++;
            }
            readPtr++;
        }


        return writePtr;
    }

    public boolean isUniq(int idx, int[] nums) {
        if (idx == 0) return true;
        if (idx == nums.length - 1) return true;
        return nums[idx] != nums[idx + 1];
    }
}
