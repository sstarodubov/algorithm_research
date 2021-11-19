package com.company.javamasterclass.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        assert 2 == new Main().missingNumber(new int[]{1, 3, 4, 5, 6, 7, 8, 9});
        assert 7 == new Main().missingNumber(new int[]{1, 2, 3, 4, 5, 6, 8, 9});
        assert Arrays.equals(new int[]{4, 3}, new Main().twoSum(new int[]{2, 3, 4, 1}, 7));
        assert Arrays.equals(new int[]{1, 6}, new Main().twoSum(new int[]{2, 3, 6, 1}, 7));

        assert new Main().permutation(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        assert !new Main().permutation(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 10});

        System.out.println("tests passed");
    }

    public boolean permutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < array1.length) {
            if (array1[ptr1] != array2[ptr2]) return false;
            ptr1++;
            ptr2++;
        }
        return true;
    }

    public int missingNumber(int[] intArray) {
        int x = 1;
        for (int num : intArray) {
            if (num == x) {
                x++;
            } else {
                return x;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            int diff = target - num;
            if (set.contains(diff)) {
                return new int[]{num, diff};
            }
            set.add(num);
        }
        return new int[]{0, 0};
    }
}


class Exercise {
    public static int[] removeDuplicates(int[] arr) {
        var map = new HashSet<Integer>();

        for (int num : arr) {
            map.add(num);
        }
        int[] result = new int[map.size()];
        int idx = 0;
        for (int s : map) {
            result[idx] = s;
            idx++;
        }

        return result;
    }
}
