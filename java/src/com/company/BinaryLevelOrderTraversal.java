package com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.buildBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        var exp = new BinaryLevelOrderTraversal();

        List<List<Integer>> lists = exp.levelOrder(tree);
        System.out.println("tests");
    }

    public List<List<Integer>> ans = new ArrayList<>();

    // Time O(n) and Space O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderHelper(root, 0);
        return ans;
    }

    public void levelOrderHelper(TreeNode node, int depth) {
        if (node != null) {
            if (ans.size() == depth) {
                var newLIst = new ArrayList<Integer>();
                newLIst.add(node.val);
                ans.add(newLIst);
            } else if (depth < ans.size()) {
                ans.get(depth).add(node.val);
            }

            levelOrderHelper(node.left, depth + 1);
            levelOrderHelper(node.right, depth + 1);
        }
    }
}
