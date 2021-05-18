package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        var m = new ValidateBinarySearchTree();

        assert !m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{1, 1,})) : -1;
        assert !m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6})) : 0;
        assert m.isValidBST(TreeNode.buildBinaryTree(new Integer[]{2, 1, 3})) : 1;
        System.out.println("tests passed");
    }

    // Time O(n) and Space O(n)
    public boolean isValidBST(TreeNode root) {
        var nodes = new ArrayList<Integer>();
        dfs(root, nodes);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i - 1) >= nodes.get(i)) return false;
        }
        return true;
    }

    public void dfs(TreeNode node, List<Integer> nodes) {
        if (node == null) return;
        dfs(node.left, nodes);
        nodes.add(node.val);
        dfs(node.right, nodes);
    }
}
