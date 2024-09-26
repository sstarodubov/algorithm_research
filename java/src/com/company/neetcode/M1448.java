package com.company.neetcode;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class M1448 {

    static class MaxList {
        private List<TreeNode> path = new ArrayList<>();
        private List<Integer> max = new ArrayList<>();

        public void add(TreeNode v) {
            if (path.isEmpty()) {
                path.add(v);
                max.add(v.val);
            } else {
                path.add(v);
                max.add(Math.max(max.getLast(), v.val));
            }
        }

        public boolean isEmpty() {
            return path.isEmpty();
        }

        public void removeLast() {
            if (path.isEmpty()) {
                return;
            }

            path.removeLast();
            max.removeLast();
        }

        public boolean isGreater(TreeNode n) {
            if (max.isEmpty()) return true;
            return n.val >= max.getLast();
        }
    }

    int ret = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, new MaxList());
        return ret;
    }


    void dfs(TreeNode node, MaxList path) {
        if (node == null) {
            return;
        }

        if (path.isGreater(node)) {
            ret++;
        }
        path.add(node);
        dfs(node.left, path);
        dfs(node.right, path);

        path.removeLast();
    }
}
