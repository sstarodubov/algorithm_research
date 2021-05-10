package com.company;

import java.util.ArrayList;
import java.util.List;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {

    public static void main(String[] args) {
        var m = new NumberofSubsequencesThatSatisfytheGivenSumCondition();

        assert 56 == m.numSubseq(new int[] {7,10,7}, 12) : 0;
        m.ans = 0;
        assert 4 == m.numSubseq(new int[]{3, 5, 6, 7}, 9) : 1;

        System.out.println("tests passed");
    }

    int ans = 0;

    public int numSubseq(int[] nums, int target) {
        ArrayList<Integer> curArr = new ArrayList<>();
        backtrack(nums, 0, curArr, target);
        return this.ans;
    }

    public void backtrack(int[] nums, int start, List<Integer> curArr, int target) {
        if (!curArr.isEmpty()) {
            int first = curArr.get(0);
            int last = curArr.get(curArr.size() - 1);
            if (first + last <= target) {
                this.ans++;
            }
        }
        for (int i = start; i < nums.length; i++) {
            curArr.add(nums[i]);
            backtrack(nums, i + 1, curArr, target);
            curArr.remove(curArr.size() - 1);
        }
    }
}
