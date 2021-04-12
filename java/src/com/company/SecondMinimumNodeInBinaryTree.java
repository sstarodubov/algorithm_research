package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SecondMinimumNodeInBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildBinaryTree(new Integer[]{2147483646,2147483647, 2147483646});
        var s = new SecondMinimumNodeInBinaryTree();
        int r = s.findSecondMinimumValue(node);
        assert 2147483647 == r : "2";


        TreeNode n = TreeNode.buildBinaryTree(new Integer[]{5,5,6});
        int r2 = s.findSecondMinimumValue(n);
        assert 6 == r2 : "6";
        System.out.println("tests passed");
    }

    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> xs = new LinkedList<>();
        findSecondMinimumValue(root, xs);
        Collections.sort(xs);
        int c = 0;
        for (int i = 0; i < xs.size(); i++) {
            if (i != 0) {
                if (!xs.get(i).equals(xs.get(i - 1))) c++;
            } else c++;
            if (c == 2) return xs.get(i);
        }
        return -1;
    }

    public void findSecondMinimumValue(TreeNode node, List<Integer> xs) {
        if (node == null) return;
        findSecondMinimumValue(node.left, xs);
        xs.add(node.val);
        findSecondMinimumValue(node.right, xs);
    }
}
