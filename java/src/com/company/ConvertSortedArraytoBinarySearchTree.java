package com.company;

public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {

        var c = new ConvertSortedArraytoBinarySearchTree();
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var nt = c.sortedArrayToBST(arr);
        System.out.println("tests passed");
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode helper = helper(nums, 0, nums.length - 1);
        return helper;
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l == r) {
            if (l == nums.length - 1) return new TreeNode(nums[l]);
            return null;
        }
        int mid = (l + r) / 2;
        var root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, l, mid);
        TreeNode right = helper(nums, mid + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }
}
