package com.company.neetcode;

import com.company.TreeNode;

import java.util.Arrays;
import java.util.Collections;

public class M105 {


    public static void main(String[] args) {
        var tree = new M105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(tree);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;


        return dfs(0, inorder.length - 1);
    }


    public TreeNode dfs(int l, int r) {
        if (preorder_idx >= preorder.length) {
            return null;
        }
        if (l == r) {
            preorder_idx++;
            return new TreeNode(inorder[l]);
        }

        if (l > r) {
            return null;
        }


        int cur_val = preorder[preorder_idx++];

        var newNode = new TreeNode(cur_val);
        int root_index = indexOf(l, r, cur_val);
        newNode.left = dfs(l, root_index - 1);
        newNode.right = dfs(root_index + 1, r);

        return newNode;
    }

    int indexOf(int l, int r, int v) {
        for (int i = l; i <= r; i++) {
            if (v == inorder[i]) {
                return i;
            }
        }

        return -1;
    }

    int[] inorder;
    int[] preorder;
    int preorder_idx = 0;
}