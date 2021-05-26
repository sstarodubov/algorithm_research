package com.company;

public class ConstructStringfromBinaryTree {
    public static void main(String[] args) {

        var con = new ConstructStringfromBinaryTree();
        assert "1(2()(4))(3)".equals(con.tree2str(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, null, 4}))) : 0;
        assert "1(2(4))(3)".equals(con.tree2str(TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, 4}))) : 1;
        System.out.println("tests passed");
    }

    // Time (n) and Space (n)
    public String tree2str(TreeNode root) {
        var str = new StringBuilder();
        helper(root, null, str);
        return str.toString();
    }

    public void helper(TreeNode node, TreeNode parent, StringBuilder str) {
        if (node == null) {
            if (parent != null && parent.right != null) str.append("()");
            return;
        }
        if (parent != null) str.append('(');
        str.append(node.val);
        helper(node.left, node, str);
        helper(node.right, node, str);
        if (parent != null) str.append(')');
        str.charAt(str.length() - 1);
    }
}
