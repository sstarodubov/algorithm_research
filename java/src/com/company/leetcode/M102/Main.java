package com.company.leetcode.M102;

import com.company.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ll = new Solution().levelOrder(TreeNode.buildBinaryTree(new Integer[]{3, 9, 20, 10, 11, 15, 7}));
        System.out.println("tests passed");
    }
}

class Pair {
    public int depth;
    public TreeNode node;

    public Pair(TreeNode node, int depth) {
        this.depth = depth;
        this.node = node;
    }
}

class Solution {

    // time O(n), space O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var ans = new ArrayList<List<Integer>>();
        var dq = new ArrayDeque<Pair>();
        int curDepth = 0;
        dq.add(new Pair(root, 0));
        var curList = new ArrayList<Integer>();
        while (!dq.isEmpty()) {
            var pair = dq.poll();
            if (curDepth == pair.depth) {
                curList.add(pair.node.val);
            } else {
                curDepth = pair.depth;
                ans.add(curList);
                curList = new ArrayList<>();
                curList.add(pair.node.val);
            }
            if (pair.node.left != null) dq.add(new Pair(pair.node.left, pair.depth + 1));
            if (pair.node.right != null) dq.add(new Pair(pair.node.right, pair.depth + 1));
        }
        ans.add(curList);
        return ans;
    }
}
