package com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public static void main(String[] args) {
        var b = new BinaryTreePath();
        assert 1 == b.binaryTreePaths(TreeNode.buildBinaryTree(new Integer[]{1})).size();
        assert 2 == b.binaryTreePaths(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, null, 5})).size();
        System.out.println("test passed");
    }

    // Time O(n^2) and Space O(1)
    public List<String> binaryTreePaths(TreeNode root) {
        var list = new ArrayList<String>();
        helper(root, list, new ArrayList<>());
        return list;
    }

    public void helper(TreeNode node, List<String> list, List<String> cur) {
        if (node == null) return;
        cur.add(String.valueOf(node.val));
        helper(node.left, list, cur);
        helper(node.right, list, cur);

        if (node.left == null && node.right == null) {
            StringBuilder join = new StringBuilder();
            if (cur.size() != 1) {
                for (int i = 0; i < cur.size(); i++) {
                    if (i == cur.size() - 1) join.append(cur.get(i));
                    else join.append(cur.get(i) + "->");
                }
                list.add(join.toString());
            } else list.add(cur.get(0));

        }

        cur.remove(cur.size() - 1);
    }
}
