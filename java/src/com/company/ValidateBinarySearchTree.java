package com.company;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        var m = new ValidateBinarySearchTree();

        assert !m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{1, 1,})) : -1;
        assert !m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6})) : 0;
        assert m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3})) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(1)
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
