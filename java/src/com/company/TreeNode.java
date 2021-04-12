package com.company;

import java.util.LinkedList;
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

    public static TreeNode buildBinaryTree(Integer[] nums) {
        if (nums.length == 0) {
            throw new UnsupportedOperationException("cannot create tree without input nums");
        }
        int p = 0;
        var root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                throw new UnsupportedOperationException("cannot create node because of null");
            }
            if (cur.left == null) {
                p++;
                if (p >= nums.length) return root;
                if (nums[p] != null) {
                    var node = new TreeNode(nums[p]);
                    cur.left = node;
                    queue.add(node);
                }
            }

            if (cur.right == null) {
                p++;
                if (p >= nums.length) return root;
                if (nums[p] != null) {
                    var node = new TreeNode(nums[p]);
                    cur.right = node;
                    queue.add(node);
                }
            }

            if (queue.isEmpty()) return root;
        }
    }
}
