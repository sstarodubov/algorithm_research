package com.company.neetcode;

import com.company.TreeNode;

public class E543 {

    int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode node) {
        dfs(node);
        return result;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lp = dfs(node.left);
        int rp = dfs(node.right);

        int cur = lp + rp;
        result = Math.max(cur, result);

        return Math.max(lp, rp) + 1;
    }
}
