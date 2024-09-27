package com.company.neetcode;

import com.company.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M102 {

    public static void main(String[] args) {
        System.out.println(
                new M102().levelOrder(TreeNode.buildBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    record Pair(TreeNode node, int depth) {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        var ret = new ArrayList<List<Integer>>();
        var dq = new ArrayDeque<Pair>();
        int prev_depth = -1;
        dq.add(new Pair(root, 0));
        while (!dq.isEmpty()) {
            var p = dq.poll();

            if (p.depth != prev_depth) {
                ret.add(new ArrayList<>());
                prev_depth = p.depth;
            }

            ret.getLast().add(p.node().val);

            if (p.node.left != null) {
                dq.add(new Pair(p.node.left, p.depth() + 1));
            }

            if (p.node.right != null) {
                dq.add(new Pair(p.node.right, p.depth + 1));
            }
        }
        return ret;
    }
}
