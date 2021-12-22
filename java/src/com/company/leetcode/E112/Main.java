package com.company.leetcode.E112;

import com.company.TreeNode;

public class Main {
    public static void main(String[] args) {
        assert !new Solution().hasPathSum(TreeNode.buildBinaryTree(new Integer[]{1, 2}), 1);
        assert !new Solution().hasPathSum(TreeNode.buildBinaryTree(new Integer[]{1, 2, null, 3, null, 4, null, 5}), 6);
        assert new Solution().hasPathSum(TreeNode.buildBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22);
        assert !new Solution().hasPathSum(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3}), 5);
        System.out.println("tests passed");
    }
}


class Solution {

    boolean ans = false;
    int target = 0;
    // time O(n), space O(h)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        target = targetSum;
        dfs(root, 0);
        return ans;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    void dfs(TreeNode node, int curSum) {
        if (ans) return;
        if (node == null) return;
        if (isLeaf(node)) {
            if (curSum + node.val == target) {
                ans = true;
                return;
            }
        }
        int newSum = curSum + node.val;
        dfs(node.left, newSum);
        dfs(node.right, newSum);
    }
}