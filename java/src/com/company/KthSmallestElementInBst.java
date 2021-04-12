package com.company;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInBst {
    public static void main(String[] args) {

        TreeNode root = TreeNode.buildBinaryTree(new Integer[]{3, 1,4, null, 2});
        var k = new KthSmallestElementInBst();
        int res = k.kthSmallest(root, 1);
        System.out.println(res);
        assert 1 == res : "1";
        System.out.println("tests passed");
    }
    // Time O(n) and Space O(n)
    public int kthSmallest(TreeNode root, int k) {
        var xs = new LinkedList<Integer>();
        kthSmallest(root, xs);
        return xs.get(k - 1);
    }

    public void kthSmallest(TreeNode node, List<Integer> list) {
        if (node == null) return;
        kthSmallest(node.left, list);
        list.add(node.val);
        kthSmallest(node.right, list);
    }
}
