package org.example.е206;

import org.example.TreeNode;

public class Main {
    public static void main(String[] args) {
        var res = new Solution().invertTree(TreeNode.buildBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}));
        System.out.println(res);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode node) {
        dfs(node);
        return node;
    }

    public void dfs(TreeNode n) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null) {
            return;
        }
        var tmp = n.left;
        n.left = n.right;
        n.right = tmp;

        dfs(n.left);
        dfs(n.right);
    }
}
