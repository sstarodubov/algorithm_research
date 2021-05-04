package com.company;

public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        var inc = new MinimumDepthofBinaryTree();

        assert 5 == inc.minDepth(TreeNode.buildBinaryTree(new Integer[]{2,null,3,null,4,null,5,null,6})) : 1;

        System.out.println("tests passed");
    }

    int ans = Integer.MAX_VALUE;

    // Time O(n) and Space O(log n)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return ans;
    }


    public void helper(TreeNode node, int depth) {
        if (node != null) {
           if (node.left == null && node.right == null) {
               ans = Math.min(depth, ans);
           }

           helper(node.left, depth + 1);
           helper(node.right, depth + 1);
        }
    }
}
