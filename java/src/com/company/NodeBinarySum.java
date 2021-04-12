package com.company;


public class NodeBinarySum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        var n1 = new TreeNode(0);
        var n2 = new TreeNode(1);
        var n3 = new TreeNode(0);
        var n4 = new TreeNode(1);
        var n5 = new TreeNode(0);
        var n6 = new TreeNode(1);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        assert 22 ==  sumRootToLeaf(root) : "22";
        System.out.println("test passed");
    }

    public static int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, "");
    }

    public static int sumRootToLeaf(TreeNode root, String out) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return Integer.parseInt(out + root.val,2);
            }
            var l = sumRootToLeaf(root.left, out + root.val);
            var r = sumRootToLeaf(root.right, out + root.val);
            return l + r;
        }
         return 0;
    }
}
