package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node(" + this.val + ")";
    }

    public static TreeNode buildBinaryTree(List<Integer> nums) {
        if (nums.size() == 0) {
            throw new UnsupportedOperationException("cannot create tree without input nums");
        }
        int p = 0;
        var root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                throw new UnsupportedOperationException("cannot create node because of null");
            }
            if (cur.left == null) {
                p++;
                if (p >= nums.size()) return root;
                if (nums.get(p) != null) {
                    var node = new TreeNode(nums.get(p));
                    cur.left = node;
                    queue.add(node);
                }
            }

            if (cur.right == null) {
                p++;
                if (p >= nums.size()) return root;
                if (nums.get(p) != null) {
                    var node = new TreeNode(nums.get(p));
                    cur.right = node;
                    queue.add(node);
                }
            }

            if (queue.isEmpty()) return root;
        }
    }
}
