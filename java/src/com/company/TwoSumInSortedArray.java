package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumInSortedArray {
    public static void main(String[] args) {
        assert Arrays.equals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9)) : "9";
        assert Arrays.equals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6)) : "6";
        assert Arrays.equals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1)) : "-1";
        System.out.println("tests 1 passed");

        TreeNode treeNode = TreeNode.buildBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        assert findSumInBst(treeNode, 9) : 9;
        assert !findSumInBst(treeNode, 28) : 28;
        assert findSumInBst(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3}), 4) : 4;
        assert !findSumInBst(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3}), 1) : 1;
        System.out.println("tests 2 passed");
    }

    // Space O(1) and Time O(n)
    public static int[] twoSum(int[] numbers, int target) {
        int lPtr = 0;
        int rPtr = numbers.length - 1;
        while (lPtr < rPtr) {
            if (numbers[lPtr] + numbers[rPtr] == target) return new int[]{lPtr + 1, rPtr + 1};
            else if (numbers[lPtr] + numbers[rPtr] < target) lPtr++;
            else rPtr--;
        }
        return new int[]{-1, -1};
    }

    // Time O(n) and Space O(n)
    public static boolean findSumInBst(TreeNode root, int k) {
        List<Integer> arr = findSumInBstHelper(root, new ArrayList<>(1000));
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            if (arr.get(l) + arr.get(r) == k) return true;
            else if (arr.get(l) + arr.get(r) < k) l++;
            else r--;
        }
        return false;
    }

    public static List<Integer> findSumInBstHelper(TreeNode node, List<Integer> arr) {
        if (node == null) return arr;
        findSumInBstHelper(node.left, arr);
        arr.add(node.val);
        findSumInBstHelper(node.right, arr);
        return arr;
    }
}
