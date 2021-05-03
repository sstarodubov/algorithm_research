package com.company;

public class DeepestLeavesSum {
    public static void main(String[] args) {

        assert 15 == deepestLeavesSum(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8})) : 1;
        assert 19 == deepestLeavesSum(TreeNode.buildBinaryTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5})) : 2;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(log n)
    public static int deepestLeavesSum(TreeNode root) {
        int[] mD = new int[]{Integer.MIN_VALUE};
        findMaxDepth(root, mD, 0);
        int[] sum = {0};
        deepestLeaveSumHelper(root, 0, sum, mD[0]);
        return sum[0];
    }

    public static void deepestLeaveSumHelper(TreeNode node, int depth, int[] sum, int needDepth) {
        if (node != null) {
            if (depth == needDepth) sum[0] += node.val;
            deepestLeaveSumHelper(node.left, depth + 1, sum, needDepth);
            deepestLeaveSumHelper(node.right, depth + 1, sum, needDepth);
        }
    }

    public static void findMaxDepth(TreeNode node, int[] d, int curDepth) {
        if (node != null) {
            if (d[0] < curDepth) d[0] = curDepth;
            findMaxDepth(node.left, d, curDepth + 1);
            findMaxDepth(node.right, d, curDepth + 1);
        }
    }
}
