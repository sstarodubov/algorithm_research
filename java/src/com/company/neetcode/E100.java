package com.company.neetcode;

import com.company.TreeNode;

public class E100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
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

       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
