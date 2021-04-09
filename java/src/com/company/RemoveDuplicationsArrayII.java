package com.company;

public class RemoveDuplicationsArrayII {

    public static void main(String[] args) {
        var e = new RemoveDuplicationsArrayII();
        assert 7 == e.removeDuplications(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) : "[0,0,1,1,1,1,2,3,3]";
        assert 2 == e.removeDuplications(new int[] {1,1}) : "[1,1]";
        assert 2 == e.removeDuplications(new int[]{1, 2}) : "[1,2]";
        assert 5 == e.removeDuplications(new int[]{1, 1, 1, 2, 2, 3}) : "[1,1,1,2,2,3]";
        System.out.println("tests passed");
    }

    public int removeDuplications(int[] nums) {
        int count = 1;
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] == nums[i]) && count < 2) {
                nums[pointer] = nums[i];
                count++;
                pointer++;
            } else if (nums[i - 1] != nums[i]) {
                nums[pointer] = nums[i - 1];
                pointer++;
                count = 1;
            }
        }
        nums[pointer] = nums[nums.length - 1];
        return pointer + 1;

    }
}
