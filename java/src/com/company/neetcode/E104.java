package com.company.neetcode;

import com.company.TreeNode;

public class E104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);

        return Math.max(ld, rd) + 1;
    }
}
