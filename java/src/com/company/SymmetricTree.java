package com.company;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        var s = new SymmetricTree();
        assert !s.isSymmetric(TreeNode.buildBinaryTree(new Integer[]{1, 2, 2, null, 3, null, 3})) : 2;
        assert s.isSymmetric(TreeNode.buildBinaryTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})) : 1;
        System.out.println("tests passed");
    }

    public boolean isSymmetric(TreeNode root) {
        var before = new ArrayList<Integer>();
        var after = new ArrayList<Integer>();
        collect(root, before);
        invertTree(root);
        collect(root, after);
        if (before.size() != after.size()) return false;
        for (int i = 0; i < after.size(); i++) {
            if (!after.get(i).equals(before.get(i))) return false;
        }
        return true;
    }

    public void collect(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(-1);
            return;
        }
        list.add(node.val);
        collect(node.left, list);
        collect(node.right, list);
    }

    public void invertTree(TreeNode node) {
        if (node == null) return;

        var tmp = node.right;
        node.right = node.left;
        node.left = tmp;

        invertTree(node.left);
        invertTree(node.right);
    }


    /* Right answer
    public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
}
     */
}
