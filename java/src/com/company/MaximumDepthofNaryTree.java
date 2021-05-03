package com.company;

import java.util.List;

public class MaximumDepthofNaryTree {
    public static void main(String[] args) {
        var inc = new MaximumDepthofNaryTree();

        var root = new Node(1);
        var n3 = new Node(3);
        var n2 = new Node(2);
        var n4 = new Node(4);
        var n5 = new Node(5);
        var n6 = new Node(6);
        root.children = List.of(n3, n2, n4);
        n3.children = List.of(n5, n6);

        assert 3 == inc.maxDepth(root);

        System.out.println("tests passed");
    }

    public int maxDepth(Node root) {
        return maxDepthHelper(root, 1, 1);
    }

    public int maxDepthHelper(Node node, int depth, int maxDepth) {
        if (node == null) return maxDepth;
        if (depth > maxDepth) maxDepth = depth;
        var children = node.children;
        if (children == null) return maxDepth;
        int ans = 0;
        for (var child : children) {
             int d = maxDepthHelper(child, depth + 1, maxDepth);
             ans = Math.max(ans, d);
        }
        return ans;
    }
}
