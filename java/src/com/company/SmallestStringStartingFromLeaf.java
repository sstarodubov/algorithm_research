package com.company;

public class SmallestStringStartingFromLeaf {

    public static void main(String[] args) {

        var s = new SmallestStringStartingFromLeaf();
        assert "dba".equals(s.smallestFromLeaf(TreeNode.buildBinaryTree(new Integer[]{0, 1, 2, 3, 4, 5, 6}))) : 1;
        s.curMin = "";
        assert "adz".equals(s.smallestFromLeaf(TreeNode.buildBinaryTree(new Integer[]{25, 1, 3, 1, 3, 0, 2}))) : 10;
        s.curMin = "";
        assert "abc".equals(s.smallestFromLeaf(TreeNode.buildBinaryTree(new Integer[]{2, 2, 1, null, 1, 0, null, 0}))) : 100;
        System.out.println("tests passed");
    }

    String curMin = "";

    public String smallestFromLeaf(TreeNode root) {
        char[] mapper = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        helper(root, new StringBuilder(), mapper);
        return curMin;
    }

    // Time O(n^2) and Space (1)
    public void helper(TreeNode node, StringBuilder sb, char[] mapper) {
        if (node == null) return;

        sb.insert(0, mapper[node.val]);
        helper(node.left, sb, mapper);
        helper(node.right, sb, mapper);

        if (node.left == null && node.right == null) {
            if (curMin.equals("")) {
                curMin = sb.toString();
            } else {
                if (curMin.compareTo(sb.toString()) > 0) {
                    curMin = sb.toString();
                }
            }
        }
        sb.deleteCharAt(0);
    }
}
