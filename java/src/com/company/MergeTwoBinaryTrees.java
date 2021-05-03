package com.company;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        var t1 = TreeNode.buildBinaryTree(new Integer[]{1, 3, 2, 5});
        var t2 = TreeNode.buildBinaryTree(new Integer[]{2, 1, 3, null, 4, null, 7});

        var inc = new MergeTwoBinaryTrees();

        TreeNode treeNode = inc.mergeTrees(t1, t2);
        assert treeNode != null;
        System.out.println("tests passed");
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
