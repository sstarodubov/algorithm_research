package com.company.neetcode;

import com.company.TreeNode;

import java.util.*;

public class M199 {


    public static void main(String[] args) {
        System.out.println(new M199().rightSideView(TreeNode.buildBinaryTree(new Integer[]{1, null, 2, null, 5, 4, 6, 3})));
    }

    Set<Integer> dSet = new HashSet<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        var ret = new ArrayList<Integer>();

        dfs(root, 0, ret);
        return ret;
    }

    void dfs(TreeNode node, int curDepth, List<Integer> view) {
        if (node == null) {
            return;
        }
        if (!dSet.contains(curDepth)) {
            dSet.add(curDepth);
            view.add(node.val);
        }
        dfs(node.right, curDepth + 1, view);
        dfs(node.left, curDepth + 1, view);


    }

}
