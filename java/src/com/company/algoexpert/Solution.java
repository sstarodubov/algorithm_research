package com.company.algoexpert;

import com.company.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Worker(String name) {}
record User (Worker worker) {}
record Refer(User user) {}

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        var tree = TreeNode.buildBinaryTree(new Integer[]{1, 3, -2, 6, -5, 5, 2, 2});
        var tu = new TreeSum();
        System.out.println(tu.splitBST(tree));
    }

    static class TreeSum {
        int result = Integer.MAX_VALUE;
        int allSum = 0;
        int splitBST(TreeNode node) {
            var map = new HashMap<TreeNode, Integer>();
            sum(node, map);
            check(node, map);
            return result;
        }

        void check(TreeNode node, Map<TreeNode, Integer> map) {
           if (result != Integer.MAX_VALUE) {
               return;
           }
           int l = map.getOrDefault(node.left, 0);

           int sumLeft = allSum - l;
           int sumRight = allSum  - sumLeft;
           if (sumLeft == sumRight) {
               result = sumLeft;
               return;
           }
           check(node.left, map);
           check(node.right, map);
        }

        int sum(TreeNode node, Map<TreeNode, Integer> map) {
            if (node == null) {
                return 0;
            }
            int l = sum(node.left, map);
            int r = sum(node.right, map);
            int s = l + r + node.val;
            map.put(node, s);
            allSum += node.val;
            return s;
        }
    }

    static class TreeUtil {

        boolean isSimetric(TreeNode node) {
            if (node == null) {
                return false;
            }

            return isSimetric(node.left, node.right);
        }

        boolean isSimetric(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return true;
            }

            if (n1 == null) {
                return false;
            }

            if (n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }

            return isSimetric(n1.left, n2.right) && isSimetric(n1.right, n2.left);
        }

        TreeNode merge(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return null;
            }
            int n;
            if (n1 == null) {
                n = n2.val;
            } else if (n2 == null) {
                n = n1.val;
            } else {
                n = n2.val + n1.val;
            }

            var newNode = new TreeNode(n);

            newNode.left = merge(n1 == null ? null : n1.left, n2 == null ? null : n2.left);
            newNode.right = merge(n1 == null ? null : n1.right, n2 == null ? null : n2.right);

            return newNode;
        }
    }

    static class BalancedTree {
        boolean bal = true;

        public boolean isBalanced(TreeNode node) {
            hight(node);
            return bal;
        }

        public int hight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int lh = hight(node.left);
            int rh = hight(node.right);

            if (Math.abs(lh - rh) > 1) {
                bal = false;
            }

            return Math.max(lh, rh) + 1;
        }
    }

    static class FindSuccessor {
        TreeNode result;
        boolean take = false;

        void successor(TreeNode node, int target) {
            successor(node, null, target);
        }

        void successor(TreeNode node, TreeNode prev, int target) {
            if (result != null) {
                return;
            }
            if (node == null) {
                return;
            }
            if (take) {
                result = node;
            }

            successor(node.left, node, target);
            if (this.take && result == null) {
                result = node;
                return;
            }
            if (node.val == target) {
                this.take = true;
            }
            successor(node.right, node, target);
        }
    }

    static class DiameterTree {
        public int result = 0;

        public int diameter(TreeNode node) {
            if (node == null) {
                return 0;
            }
            if (node.right == null && node.left == null) {
                return 1;
            }

            int l = diameter(node.left);
            int r = diameter(node.right);
            result = Math.max(result, l + r);
            return 1 + Math.max(l, r);
        }
    }

    static class InverBinaryTree {

        public void invert(TreeNode node) {
            if (node == null) {
                return;
            }

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            invert(node.left);
            invert(node.right);
        }
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
