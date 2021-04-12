package com.company;

public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        var m = new MinimumDistanceBetweenBSTNodes();
        TreeNode tree = new TreeNode(5);
        var l1 = new TreeNode(1);
        var r7 = new TreeNode(7);

        tree.left = l1;
        tree.right = r7;
        int i = m.minDiffInBst(tree);
        assert 2 == i;
        System.out.println("tests passed");
    }

    private long prevNodeVal = Integer.MIN_VALUE;
    private int out = Integer.MAX_VALUE;

    //time O(n) and space O(n)
    private void compute(TreeNode node) {
        if (node != null) {
            compute(node.left);
            long newDiff = node.val - prevNodeVal;
            if (newDiff == 0) newDiff = Integer.MAX_VALUE;
            if (newDiff < out) out = (int) newDiff;
            prevNodeVal = node.val;
            compute(node.right);
        }
    }

    public int minDiffInBst(TreeNode node) {
        compute(node);
        return out;
    }
}
