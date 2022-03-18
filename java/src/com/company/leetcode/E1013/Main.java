package com.company.leetcode.E1013;

public class Main {
    public static void main(String[] args) {
        assert new Solution().canThreePartsEqualSum(new int[]{0, 0, 0, 0});
        assert new Solution().canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
        assert !new Solution().canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
        assert new Solution().canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
        System.out.println("tests passed");
    }
}

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        if (sum % 3 != 0) return false;

        int p = sum / 3;
        int x = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur == p) {
                cur = 0;
                x++;
                if (x == 3) {
                    int k = i + 1;
                    while (k < arr.length && arr[k] == 0) {
                        if (arr[k] != 0) return false;
                        k++;
                    }
                    return true;
                }
            }
        }

        return false;
    }
}