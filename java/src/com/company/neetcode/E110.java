package com.company.neetcode;

import com.company.TreeNode;

public class E110 {

    public static void main(String[] args) {
        assert new E110().isBalanced(TreeNode.buildBinaryTree(new Integer[] {1}));
        assert new E110().isBalanced(null);
    }
    boolean result = true;
    public boolean isBalanced(TreeNode root) {

        dfs(root);

        return result;
    }

    int dfs(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        if (!result) {
            return -1;
        }

        int ld = dfs(tn.left);
        int rd = dfs(tn.right);

        if (Math.abs(rd - ld) > 1) {
            result = false;
            return -1;
        }
        int cur = Math.max(ld, rd) + 1;
        return cur;
    }
}
