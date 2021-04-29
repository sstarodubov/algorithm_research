package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        var m = new FindBottomLeftTreeValue();
        assert 7 == m.findBottomLeftValue(TreeNode.buildBinaryTree(new Integer[] {1,2,3,4,null,5,6,null,null,7})) : 2;
        assert 1 == m.findBottomLeftValue(TreeNode.buildBinaryTree(new Integer[]{2,1,3})) : 1;
        System.out.println("tests passed");
    }

    // Space O(n) and Time O(n)
    public int findBottomLeftValue(TreeNode root) {
        var list = new ArrayList<int[]>();
        helper(root, 0, list);
        int d = 0;
        int ans = 0;
        for (var pair : list) {
            if (pair[1] > d) {
                d = pair[1];
                ans = pair[0];
            }
        }
        return ans;
    }

    public void helper(TreeNode node, int depth, List<int[]> out) {
        if (node != null) {
            helper(node.left, depth + 1, out);
            out.add(new int[] {node.val, depth});
            helper(node.right, depth + 1, out);
        }
    }
}
