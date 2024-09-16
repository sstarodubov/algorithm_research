package com.company.neetcode;

public class M74 {

    public static void main(String[] args) {
        /*
        System.out.println(new M74().searchMatrix(new int[][]{
                        {1},
                        {10},
                        {20},
                        {30},
                        {40},
                        {50},
                        {60},
                        {70},
                        {80},
                        {90},
                        {100}
                },
                -1));
         */

        assert new M74().searchMatrix(new int[][]{
                {1}, {3}
        }, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int l = 0, r = n - 1, m;

        while (l < r) {
            m = (l + r) / 2;
            if (matrix[m][0] == target) {
                return true;
            }

            if (m == 0) {
                l = 0;
                if (matrix[m + 1][0] == target) {
                    return true;
                }
                break;
            }

            if (m == n - 1) {
                l = n - 1;
                break;
            }


            if (matrix[m][0] < target && matrix[m + 1][0] > target) {
                l = m;
                break;
            }

            if (matrix[m][0] > target && matrix[m + 1][0] > target) {
                r = m;
            } else {
                l = m + 1;
            }

        }
        return search(matrix[l], target) != -1;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m;

        while (l <= r) {
            m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }


        return -1;
    }
}
