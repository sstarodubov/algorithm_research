package com.company;

import java.util.*;

public class FindModeinBinarySearchTree {

    public static void main(String[] args) {
        var m = new FindModeinBinarySearchTree();
        assert Arrays.equals(new int[]{1, 2}, m.findMode(TreeNode.buildBinaryTree(new Integer[]{1, null, 2}))) : -1;
        assert Arrays.equals(new int[]{0}, m.findMode(TreeNode.buildBinaryTree(new Integer[]{0}))) : -2;
        assert Arrays.equals(new int[]{2}, m.findMode(TreeNode.buildBinaryTree(new Integer[]{1, null, 2, 2}))) : 1;
        System.out.println("tests passed");
    }

    int maxCount = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        var map = new HashMap<Integer, Integer>();
        dfs(root, map);
        var ans = new ArrayList<Integer>();
        for (var set : map.entrySet()) {
            if (set.getValue() == maxCount) ans.add(set.getKey());
        }
        var r = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            r[i] = ans.get(i);
        }
        return r;
    }

    public void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;
        dfs(node.left, map);
        var count = map.getOrDefault(node.val, 0);
        count++;
        this.maxCount = Math.max(count, this.maxCount);
        map.put(node.val, count);
        dfs(node.right, map);
    }
}
