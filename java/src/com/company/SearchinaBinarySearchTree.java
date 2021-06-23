package com.company;

public class SearchinaBinarySearchTree {

    public static void main(String[] args) {
        var s = new SearchinaBinarySearchTree();
        TreeNode treeNode = s.searchBST(TreeNode.buildBinaryTree(new Integer[]{4, 2, 7, 1, 3}), 2);
        System.out.println(treeNode);
    }

    // Time O(log n ) and Space O(log n)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
