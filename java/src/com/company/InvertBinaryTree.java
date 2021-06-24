package com.company;

public class InvertBinaryTree {

    public static void main(String[] args) {
        var i = new InvertBinaryTree();
        TreeNode treeNode = i.invertTree(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, 4, 5}));
        assert treeNode.val == 1;
        System.out.println("tests passed");
    }

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;

    }

    public void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);
        helper(node.right);


        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;

    }
}
