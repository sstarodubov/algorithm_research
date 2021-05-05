package com.company;

public class CountRange {
    public static void main(String[] args) {
        var one = new CountRange();

        assert 3 == one.countRangeSum(new int[]{-2, 5, -1}, -2, 2) : 1;
        assert 1 == one.countRangeSum(new int[] {0}, 0 , 0) : 2;

        System.out.println("tests passed");
    }
    // Space O(1) and Time O(n ^3)
    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i > j) continue;
                int sum = 0;
                boolean flag = false;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                    flag = true;
                }
                if (sum >= lower && sum <= upper && flag) ans++;
            }
        }
        return ans;
    }
}
