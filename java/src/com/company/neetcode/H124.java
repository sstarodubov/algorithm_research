package com.company.neetcode;

import com.company.TreeNode;

public class H124 {
    public static void main(String[] args) {
        assert 16 == new H124()
                .maxPathSum(TreeNode.buildBinaryTree(new Integer[]{9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6}));
    }

    public int maxPathSum(TreeNode root) {
        if (root != null) {
            result = root.val;
        }
        dfs(root);
        System.out.println(result);
        return result;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_sum = dfs(node.left);
        int right_sum = dfs(node.right);

        int cur_path = left_sum + right_sum + node.val;
        int pass = node.val + left_sum;
        int pass2 = node.val + right_sum;
        int pass3 = node.val + Math.max(left_sum, right_sum);
        int ret = Math.max(pass3, Math.max(pass2, pass));
        ret = Math.max(ret, node.val);
        result = Math.max(result, ret);
        result = Math.max(result, cur_path);
        result = Math.max(result, node.val);
        return ret;
    }

    int result = 0;
}
