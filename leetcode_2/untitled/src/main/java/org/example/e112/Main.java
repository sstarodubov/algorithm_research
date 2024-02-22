package org.example.e112;

import org.example.TreeNode;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().hasPathSum(TreeNode.buildBinaryTree(new Integer[]{
                        5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
                }
        ), 22));
    }
}


class Solution {

    private int targetSum;
    private boolean ret;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        this.targetSum = targetSum;
        dfs(root, 0);
        return ret;
    }

    public void dfs(TreeNode n, int cur) {
        if (n == null) return;
        cur += n.val;
        if (n.left == null && n.right == null) {
            if (cur == targetSum) {
                ret = true;
            }
        } else {
            dfs(n.left, cur);
            dfs(n.right, cur);
        }
    }
}
