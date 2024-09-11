package com.company.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new M15().threeSum(new int[]{-2, 0, 1, 1, 2});

        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        var ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        int i = 0, l, r, n = nums.length, m;

        while (i < n - 1) {
            l = i + 1;
            r = n - 1;
            while (l != i && r != i && l < r) {
                m = nums[l] + nums[r] + nums[i];
                if (m == 0) {
                    ret.add(List.of(nums[l], nums[r], nums[i]));
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else if (m > 0) {
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else {
                    do {
                        l++;
                    } while (l < r && nums[l - 1] == nums[l]);
                }
            }
            do {
                i++;
            } while (i < n - 1 && nums[i] == nums[i - 1]);
        }
        return ret;
    }
}
