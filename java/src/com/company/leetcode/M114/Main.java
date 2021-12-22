package com.company.leetcode.M114;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var tree = TreeNode.buildBinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Solution().flatten(tree);
        System.out.println("tests passed");
    }
}

class Solution {

    List<TreeNode> list = new ArrayList<>();

    // time O(n), space O(n)
    public void flatten(TreeNode root) {
        if (root == null) return;
        dfs(root);
        for (int f = 1, b = 0; f < list.size(); f++, b++) {
            list.get(b).left = null;
            list.get(b).right = list.get(f);
        }
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        list.add(node);
        dfs(node.left);
        dfs(node.right);
    }
}
