package com.company;

public class RemoveDuplicationSortedArray {
    public static void main(String[] args) {
        var r = new RemoveDuplicationSortedArray();
        assert 2 == r.removeDuplicates(new int[] {1,2,2});
        assert 2 == r.removeDuplicates(new int[] {1,1,2}) : "[1,1,2]";
        assert 5 == r.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}) : "[0,0,1,1,1,2,2,2,3,3,4]";
        assert 1 == r.removeDuplicates(new int[] {1,1}): "[1,1]";

        System.out.println("tests passed");
    }

    // Space O(1) and Time O(n)
    public int removeDuplicates(int[] nums) {
        int out = 1;
        int c = 0;
        int p = 0;
        int i = 0;

        while (true) {
            while (p < nums.length  && nums[c] == nums[p]) {
                p++;
            }
            if (p == nums.length) return out;
            out++;
            i++;
            nums[i] = nums[p];
            c = p;
            p++;
        }
    }
}
