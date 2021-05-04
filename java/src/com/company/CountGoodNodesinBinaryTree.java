package com.company;

public class CountGoodNodesinBinaryTree {
    public static void main(String[] args) {
        var inc = new CountGoodNodesinBinaryTree();
        TreeNode tree = TreeNode.buildBinaryTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
        assert 4 == inc.goodNodes(TreeNode.buildBinaryTree(new Integer[] {2,null,4,10,8,null,null,4})) : 0;
        inc.count = 0;
        assert 4 == inc.goodNodes(tree) : 1;

        System.out.println("tests passed");
    }

    int count = 0;
    public int goodNodes(TreeNode root) {
        goodNodesHelper(root,  root.val);
        System.out.println(count);
        return count;
    }

    public void goodNodesHelper(TreeNode node,  int threshold) {
        if (node != null) {
            threshold = Math.max(threshold, node.val);
            goodNodesHelper(node.left, threshold);
            if (node.val == threshold) count++;
            goodNodesHelper(node.right, threshold);
        }
    }
}
