package com.company.neetcode;

import com.company.TreeNode;

public class M98 {

    public static void main(String[] args) {
        assert new M98().isValidBST(TreeNode.buildBinaryTree(new Integer[]{3, 1, 5, 0, 2, 4, 6}));
        assert !new M98().isValidBST(TreeNode.buildBinaryTree(new Integer[]{5, 4, 6, null, null, 3, 7}));
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean dfs = dfs(root.left, root.val, Long.MIN_VALUE);
        boolean dfs2 = dfs(root.right, Long.MAX_VALUE, root.val);

        return dfs && dfs2;
    }


    boolean dfs(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }

        if (node.val >= max) {
            return false;
        }

        if (node.val <= min) {
            return false;
        }

        return dfs(node.left, node.val, min) && dfs(node.right, max, node.val);

    }
}
