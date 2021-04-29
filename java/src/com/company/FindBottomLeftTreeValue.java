package com.company;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        var m = new FindBottomLeftTreeValue();
        assert 7 == m.findBottomLeftValue(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7})) : 2;
        assert 1 == m.findBottomLeftValue(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3})) : 1;
        System.out.println("tests passed");
    }

    // Space O(log d) d - depth of tree and Time O(n) n - amount of tree nodes
    public int findBottomLeftValue(TreeNode root) {
        int[] pair = new int[2];
        helper(root, 1, pair);
        return pair[0];
    }

    public void helper(TreeNode node, int depth, int[] pair) {
        if (node != null) {
            helper(node.left, depth + 1, pair);
            if (pair[1] < depth) {
                pair[1] = depth;
                pair[0] = node.val;
            }
            helper(node.right, depth + 1, pair);
        }
    }
}
