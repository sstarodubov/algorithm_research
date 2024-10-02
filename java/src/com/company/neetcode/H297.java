package com.company.neetcode;

import com.company.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
//Tree Parsing
public class H297 {

    public static void main(String[] args) {
        var codec = new Codec();
        var tree = TreeNode.buildBinaryTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        var s = codec.serialize(tree);
        var d = codec.deserialize(s);

        System.out.println(d);
    }


    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode node) {
            Queue<TreeNode> dq = new LinkedList<>();
            dq.add(node);
            var ints = new ArrayList<String>();
            while (!dq.isEmpty()) {
                var poll = dq.poll();
                if (poll == null) {
                    ints.add("$");
                } else {
                    ints.add(String.valueOf(poll.val));
                    dq.add(poll.left);
                    dq.add(poll.right);
                }
            }

            return "%s:%s".formatted(
                    ints.size(),
                    String.join(",", ints)
            );
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Integer[] integers = data_to_arr(data);
            if (integers.length == 0) {
                return null;
            }

            if (integers.length == 1 && integers[0] == null) {
                return null;
            }

            return buildBinaryTree(integers);
        }

        TreeNode buildBinaryTree(Integer[] nums) {
            int p = 0;
            var root = new TreeNode(nums[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (true) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    throw new UnsupportedOperationException("cannot create node because of null");
                }
                if (cur.left == null) {
                    p++;
                    if (p >= nums.length) return root;
                    if (nums[p] != null) {
                        var node = new TreeNode(nums[p]);
                        cur.left = node;
                        queue.add(node);
                    }
                }

                if (cur.right == null) {
                    p++;
                    if (p >= nums.length) return root;
                    if (nums[p] != null) {
                        var node = new TreeNode(nums[p]);
                        cur.right = node;
                        queue.add(node);
                    }
                }

                if (queue.isEmpty()) return root;
            }
        }

        Integer[] data_to_arr(String data) {
            int split = data.indexOf(":");
            int size = Integer.parseInt(data.substring(0, split));
            var ret = new Integer[size];
            int i = split + 1;
            int p = 0;
            StringBuilder sb = new StringBuilder();
            while (i < data.length()) {
                if (data.charAt(i) == ',') {
                    ret[p] = sb.toString().equals("$") ? null : Integer.valueOf(sb.toString());
                    p++;
                    sb.setLength(0);
                } else {
                    sb.append(data.charAt(i));
                }
                i++;
            }

            if (!sb.isEmpty()) {
                ret[p] = sb.toString().equals("$") ? null : Integer.valueOf(sb.toString());
            }

            return ret;
        }
    }
}
