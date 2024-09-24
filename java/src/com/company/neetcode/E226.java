package com.company.neetcode;

import com.company.TreeNode;

public class E226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
