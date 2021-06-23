package com.company;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

        var c = new CombinationSum();

        List<List<Integer>> lists = c.combinationSum(new int[]{2, 3, 6, 7}, 7);

        System.out.println("test passed");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var ans = new ArrayList<List<Integer>>();
        var curList = new ArrayList<Integer>();
        return helper(candidates, target, curList, ans, 0);
    }

    public List<List<Integer>> helper(int[] candidates, int target, List<Integer> curList, List<List<Integer>> ans, int idx) {
        int sum = 0;
        for (var el : curList) {
            sum += el;
        }
        if (sum == target) {
            var copy = new ArrayList<>(curList);
            ans.add(copy);
            return ans;
        }
        if (sum > target) {
            return ans;
        }
        for (int i = idx; i < candidates.length; i++) {
            curList.add(candidates[i]);
            helper(candidates, target, curList, ans, i);
            curList.remove(curList.size() - 1);
        }
        return ans;
    }
}
