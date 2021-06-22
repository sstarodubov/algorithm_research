package com.company;

import java.util.ArrayList;
import java.util.List;

public class IsSameTree {
    public static void main(String[] args) {
        var t = new IsSameTree();
        assert !t.isSameTree(TreeNode.buildBinaryTree(new Integer[]{1, null, 1}), TreeNode.buildBinaryTree(new Integer[]{1, 1})) : 10;
        assert t.isSameTree(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3}), TreeNode.buildBinaryTree(new Integer[]{1, 2, 3})) : 1;
        assert !t.isSameTree(TreeNode.buildBinaryTree(new Integer[]{1, 2}), TreeNode.buildBinaryTree(new Integer[]{1, null, 2})) : 1;
        assert !t.isSameTree(TreeNode.buildBinaryTree(new Integer[]{1, 2, 1}), TreeNode.buildBinaryTree(new Integer[]{1, 1, 2})) : 2;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var pl = new ArrayList<Integer>();
        var ql = new ArrayList<Integer>();
        helper(p, pl);
        helper(q, ql);
        if (pl.size() != ql.size()) return false;
        for (int i = 0; i < pl.size(); i++) {
            if (!pl.get(i).equals(ql.get(i))) return false;
        }
        return true;
    }

    public void helper(TreeNode p, List<Integer> str) {
        if (p != null) {
            str.add(p.val);
            helper(p.left, str);
            helper(p.right, str);
        } else str.add(-1);
    }
}
