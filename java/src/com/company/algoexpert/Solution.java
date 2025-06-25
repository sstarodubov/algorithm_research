package com.company.algoexpert;

import com.company.TreeNode;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        var node = new ReconstructBst().build(List.of(10, 4, 2, 1, 5, 17, 19, 18));
        node.print();
    }

    static class ReconstructBst {

        TreeNode build(List<Integer> arr) {
            if (arr.isEmpty()) {
                return null;
            }

            var node = new TreeNode(arr.getFirst());

            int ridx = arr.size();
            for (int i = 0; i < arr.size(); i++) {
                if (node.val < arr.get(i)) {
                   ridx = i;
                   break;
                }
            }

            node.left = build(new Slice<>(arr, 1, ridx));
            node.right = build(new Slice<>(arr, ridx, arr.size()));
            return node;
        }
    }


    static class FindKthLargestInBst {
        boolean found;
        int count = 0;
        TreeNode prev = new TreeNode(-1);
        int result = -1;

        int findKthLargestValueInBST(TreeNode node, int k) {
            findKth(node, k);
            return result;
        }

        void findKth(TreeNode cur, int k) {
            if (cur == null) {
                return;
            }

            findKth(cur.left, k);
            if (prev.val != cur.val) {
                count += 1;
                if (count == k) {
                    result = cur.val;
                    return;
                }
            }
            prev = cur;
            findKth(cur.right, k);
        }
    }
}
