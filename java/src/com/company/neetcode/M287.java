package com.company.neetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class M287  {

    public static void main(String[] args) {
        new M287().findDuplicate(new int[]{4, 3, 1, 4, 2});
    }

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0, slow2 = 0;
        int n = nums.length;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) {
                return slow;
            }
        }

    }
}
