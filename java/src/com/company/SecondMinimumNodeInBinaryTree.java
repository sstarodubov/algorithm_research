package com.company;

public class SecondMinimumNodeInBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildBinaryTree(new Integer[]{2,2,5,null,null,5,7});
        var s = new SecondMinimumNodeInBinaryTree();
        int r = s.findSecondMinimumValue(node);
        assert  5 == r;
        System.out.println("tests passed");
    }

    int tmp;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode root) {
        if (root != null) {
            if (tmp < root.val && root.val < ans) {
                ans = root.val;
            } else if (tmp == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        tmp = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}

