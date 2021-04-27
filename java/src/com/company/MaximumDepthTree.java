package com.company;

public class MaximumDepthTree {
    public static void main(String[] args) {

        var el = new MaximumDepthTree();

        TreeNode t1 = TreeNode.buildBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode t2 = TreeNode.buildBinaryTree(new Integer[] {1,null,2});
        TreeNode t4 = TreeNode.buildBinaryTree(new Integer[]{0});

        assert 3 == el.maxDepth(t1) : 1;
        assert 2 == el.maxDepth(t2) : 2;
        assert 0 == el.maxDepth(null) : 3;
        assert 1 == el.maxDepth(t4) : 4;

        System.out.println("tests passed");
    }

    // Time O(n) and Space O(log d) where d - depth of binary tree
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthHelper(root, 1) - 1;
    }

    private int maxDepthHelper(TreeNode node, int depth) {
        if (node != null) {
            int ld = maxDepthHelper(node.left, depth + 1);
            int rd = maxDepthHelper(node.right, depth + 1);
            return Math.max(ld, rd);
        }
        return depth;
    }
}
