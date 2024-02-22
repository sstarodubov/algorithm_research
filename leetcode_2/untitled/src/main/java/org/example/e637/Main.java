package org.example.e637;

import org.example.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().averageOfLevels(TreeNode.buildBinaryTree(new Integer[]{
                3, 9, 20, null, null, 15, 7
        })));
    }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        var ret = new ArrayList<Double>();
        bfs(root, ret);
        return ret;
    }

    record Pair(int d, TreeNode n) {
    }

    static class Result {
        public double sum = 0;
        public int count = 0;

        public Result(double sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        public Result() {
        }
    }


    private void bfs(TreeNode node, ArrayList<Double> ret) {
        var dq = new ArrayDeque<Pair>();
        dq.addLast(new Pair(0, node));
        var map = new HashMap<Integer, Result>();
        while (!dq.isEmpty()) {
            Pair pair = dq.pollFirst();
            var cur = map.getOrDefault(pair.d(), new Result());
            cur.count += 1;
            cur.sum += pair.n.val;
            map.put(pair.d(), cur);
            if (pair.n().left != null) {
                dq.addLast(new Pair(pair.d() + 1, pair.n().left));
            }
            if (pair.n().right != null) {
                dq.addLast(new Pair(pair.d() + 1, pair.n().right));
            }
        }
        int level = 0;

        while (map.containsKey(level)) {
            var res = map.get(level++);
            ret.add(res.sum / res.count);
        }
    }
}

