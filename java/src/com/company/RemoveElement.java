package com.company;

public class RemoveElement {
    public static void main(String[] args) {

        assert 2 == removeElement(new int[]{3, 3}, 5) : 21;
        assert 0 == removeElement(new int[]{3, 3}, 3) : 22;
        assert 5 == removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        assert 2 == removeElement(new int[]{3, 2, 2, 3}, 2) : 1;
        System.out.println("tests passed");
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] == val) return 0;
        if (nums.length == 1) return 1;
        int s = 0;
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (r > 0 && nums[r] == val) r--;

            while (l < nums.length && nums[l] != val) {
                l++;
            }

            if (l >= r) break;
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        int sz = nums.length - 1;
        while (sz >= 0 && nums[sz] == val) {
            sz--;
            s++;
        }
        return nums.length - s;
    }
}
