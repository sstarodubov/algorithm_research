package com.company.neetcode;

import com.company.TreeNode;

public class E572 {

    boolean result = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        dfs(root, subRoot);

        return result;
    }

    void dfs(TreeNode r, TreeNode s) {
        if (r == null || result) {
            return;
        }

        dfs(r.left, s);
        if (isSame(r, s)) {
            result = true;
            return;
        }
        dfs(r.right, s);
    }

    boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null) {
            return false;
        }

        if (q == null) {
            return false;
        }

        if (q.val != p.val) {
            return false;
        }

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
