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
        List<List<Integer>> helper = helper(candidates, target, curList, ans);
        return helper;
    }

    public List<List<Integer>> helper(int[] candidates, int target, List<Integer> curList, List<List<Integer>> ans) {
        int sum = curList.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            var copy = new ArrayList<>(curList);
            ans.add(copy);
            return ans;
        }
        if (sum > target) {
            return ans;
        }
        for (int el : candidates) {
            if (sum < target) {
                curList.add(el);
                helper(candidates, target, curList, ans);
            }
            if (!curList.isEmpty()) {
                curList.remove(curList.size() - 1);
            }
        }
        return ans;
    }
}
