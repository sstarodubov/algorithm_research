package com.company.neetcode;

import com.company.TreeNode;

public class M230 {

    public static void main(String[] args) {
        System.out.println(new M230().kthSmallest(TreeNode.buildBinaryTree(new Integer[]{5,3,6,2,4,null,null,1}),3));
    }
    TreeNode prev = new TreeNode(Integer.MAX_VALUE);
    int curK = 0;
    TreeNode result = null;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return result.val;
    }

    void dfs(TreeNode cur, int k) {
        if (result != null) {
            return;
        }

        if (cur == null) {
            return;
        }

        dfs(cur.left, k);

        if (cur.val != prev.val) {
            curK++;
        }

        if (curK == k) {
            result = cur;
            return;
        }

        prev = cur;
        dfs(cur.right, k);
    }
}
