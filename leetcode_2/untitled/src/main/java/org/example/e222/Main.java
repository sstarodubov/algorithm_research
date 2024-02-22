package org.example.e222;

import org.example.TreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}


class Solution {
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int nLeft = countNodes(node.left);
        int nRight = countNodes(node.right);

        return nLeft + nRight + 1;
    }
}
