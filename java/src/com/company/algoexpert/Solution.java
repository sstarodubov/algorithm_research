package com.company.algoexpert;

import com.company.ListNode;
import com.company.TreeNode;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

record Node(char val, List<Node> children) {
    public Node(char val) {
        this(val, new ArrayList<>());
    }
}

public class Solution {


    public static void main(String[] args) {
       var pm = new PhoneMnemonic("1905");

        System.out.println(pm.generate());
    }

    public static class PhoneMnemonic {
        String input;
        Map<Character, String> m = Map.of(
                '1' , "1",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wyxz",
                '0', "0"

        );
        public PhoneMnemonic(String input) {
           this.input = input;
        }

        List<String> generate() {
            var result = new ArrayList<String>();
            _generate(0, new StringBuilder(), result);
            return result;
        }

        private void _generate(int idx, StringBuilder comb, List<String> result) {
           if (idx >= input.length()) {
               result.add(comb.toString());
           } else {
               char digit = input.charAt(idx);
               String letters = m.get(digit);
               for (int i = 0; i < letters.length(); i++) {
                    comb.append(letters.charAt(i));
                    _generate(idx + 1, comb, result);
                    comb.deleteCharAt(comb.length() - 1);
               }
           }
        }
    }

    public static List<Integer> copy(int[] arr) {
        var r = new ArrayList<Integer>(arr.length);
        for (var i : arr) {
            r.add(i);
        }
        return r;
    }

    public static List<Integer> copy(List<Integer> arr) {
        var r = new ArrayList<Integer>(arr.size());
        r.addAll(arr);
        return r;
    }


    public static List<List<Integer>> deepCopy(List<List<Integer>> arr) {
        var r = new ArrayList<List<Integer>>(arr.size());
        for (var list : arr) {
            r.add(copy(list));
        }
        return r;
    }

    public static class PowerSet {
        int[] set;

        public PowerSet(int[] set) {
            this.set = set;
        }

        List<List<Integer>> generate() {
            final var ret = new ArrayList<List<Integer>>();
            ret.add(new ArrayList<>());

            for (var n : set) {
                List<List<Integer>> copy = deepCopy(ret);
                for (var list : copy) {
                    list.add(n);
                }

                ret.addAll(copy);
            }

            return ret;
        }
    }

    public static class Permutations {
       List<List<Integer>> solve(int[] arr)  {
            var ret = new ArrayList<List<Integer>>();

            solve(arr, 0, ret);


            return ret;
       }


       void swap(int[] arr, int i, int j) {
           int t = arr[i];
           arr[i] = arr[j];
           arr[j] = t;
       }

       void solve(int[] arr, int idx, List<List<Integer>> result) {
            if (idx  >= arr.length) {
               result.add(copy(arr));
            } else {
                for (int i = idx; i < arr.length; i++) {
                   swap(arr, i, idx);
                   solve(arr, idx + 1, result);
                   swap(arr, i, idx);
                }
            }
       }
    }

    public static class MergeTwoList {

        public ListNode commonNode(ListNode n1, ListNode n2) {
            var set = new HashSet<ListNode>();

            var cur = n1;
            while (cur != null) {
               set.add(cur);
               cur = cur.next;
            }

            cur = n2;

            while (cur != null) {
                if (set.contains(cur)) {
                    return cur;
                }

                cur = cur.next;
            }

            return null;
        }
    }
    public static class SumOfLinkedList {
        ListNode sum(ListNode n1 , ListNode n2) {
            int carry = 0;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (n1 != null && n2 != null) {
                int a = n1.val + n2.val + carry;

                if (a > 9) {
                   carry = 1;
                   a = a % 10;
                } else {
                    carry = 0;
                }
                cur.next = new ListNode(a);
                cur = cur.next;
                n1 = n1.next;
                n2 = n2.next;
            }

            while (n1 != null) {
                int a = n1.val + carry;

                if (a > 9) {
                    carry = 1;
                    a = a % 10;
                } else {
                    carry = 0;
                }
                cur.next = new ListNode(a);
                cur = cur.next;
                n1 = n1.next;
            }

            while (n2 != null) {
                int a = n2.val + carry;

                if (a > 9) {
                    carry = 1;
                    a = a % 10;
                } else {
                    carry = 0;
                }
                cur.next = new ListNode(a);
                cur = cur.next;
                n2 = n2.next;
            }

            if (carry == 1) {
                cur.next = new ListNode(1);
            }

            return dummy.next;
        }
    }

    public static class RemoveNthNodeFromLinkedList {
        ListNode node;
        int end;

        public RemoveNthNodeFromLinkedList(ListNode node, int end) {
           this.node = node;
           this.end = end;
        }


        public ListNode removeNth() {
            var dummy = new ListNode(-1);
            dummy.next = node;
            ListNode f = node, s = dummy;
            int i = 0;
            while (i < end) {
               f = f.next;
               i++;
            }

            while (f != null) {
               s = s.next;
               f = f.next;
            }

            if (s.next != null) {
                var a = s.next;
                s.next = s.next.next;
                a.next = null;
            }

            return dummy.next;
        }
    }

    public static class TaskAssignment {
        int k;
        int[] arr;

        public TaskAssignment(int k, int[] arr) {
            this.k = k;
            this.arr = arr;
        }

        public int[][] resolve() {
            var m = new HashMap<Integer, List<Integer>>();
            int[][] ret = new int[k][2];

            for (int i = 0; i < arr.length; i++) {
                var list = m.getOrDefault(arr[i], new ArrayList<>());
                list.add(i);
                m.put(arr[i], list);
            }

            Arrays.sort(arr);

            int r = k, l = k - 1, i = 0;

            while (l >= 0 && r < arr.length && i < k) {
                ret[i] = new int[] {m.get(arr[l]).removeLast(), m.get(arr[r]).removeLast()};
                i ++;
                l--;
                r++;
            }
            return ret;
        }
    }

    public static class TwoColarableGraph {
        record Edge(int from, int to) {

            public static Edge create(int from, int to) {
                if (from < to) {
                    return new Edge(from, to);
                } else {
                    return new Edge(to, from);
                }
            }
        }

        int[][] g;
        Set<Edge> edges = new HashSet<>();

        public TwoColarableGraph(int[][] g) {
            this.g = g;

            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    edges.add(Edge.create(i, g[i][j]));
                }
            }
        }

        boolean isTwoColarable() {
            var m = new HashMap<Integer, Integer>();

            for (var edge : this.edges) {
                var toColor = m.get(edge.to);
                var fromColor = m.get(edge.from);

                if (toColor == null && fromColor == null) {
                    m.put(edge.to, 1);
                    m.put(edge.from, -1);
                } else if (toColor == null) {
                    m.put(edge.to, -fromColor);
                } else if (fromColor == null) {
                    m.put(edge.from, -toColor);
                } else {
                    if (toColor.equals(fromColor)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static class MininumPassOfMatrix {
        record Pair(int r, int c, int level, int val) {
        }

        int[][] m;

        public MininumPassOfMatrix(int[][] m) {
            this.m = m;
        }

        boolean canGo(int r, int c) {
            if (r >= m.length || r < 0) {
                return false;
            }

            if (c >= m[0].length || c < 0) {
                return false;
            }

            if (m[r][c] < 0) {
                return true;
            }

            return false;
        }

        int passes() {
            var pairs = new ArrayList<Pair>();
            int cycles = 0;
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m[0].length; c++) {
                    int n = m[r][c];
                    if (n > 0) {
                        pairs.add(new Pair(r, c, 0, m[r][c]));
                    }
                }
            }

            while (!pairs.isEmpty()) {
                var cur = pairs.removeFirst();
                var r = cur.r;
                var c = cur.c;
                var l = cur.level;
                m[r][c] = Math.abs(m[r][c]);
                cycles = Math.max(cycles, l);
                if (canGo(r + 1, c)) {
                    pairs.addLast(new Pair(r + 1, c, l + 1, m[r + 1][c]));
                }
                if (canGo(r - 1, c)) {
                    pairs.addLast(new Pair(r - 1, c, l + 1, m[r - 1][c]));
                }
                if (canGo(r, c - 1)) {
                    pairs.addLast(new Pair(r, c - 1, l + 1, m[r][c - 1]));
                }
                if (canGo(r, c + 1)) {
                    pairs.addLast(new Pair(r, c + 1, l + 1, m[r][c + 1]));
                }
            }

            return cycles;
        }
    }


    public static class CicleInGraph {
        boolean result = false;

        enum State {
            WHITE, BLACK, GREY
        }

        State[] states;
        int[][] g;

        public CicleInGraph(int[][] g) {
            this.g = g;
            this.states = new State[g.length];
            Arrays.fill(states, State.WHITE);
        }

        boolean exists() {
            for (int i = 0; i < g.length; i++) {
                if (states[i] == State.WHITE) {
                    dfs(i);
                } else if (states[i] == State.GREY) {
                    return true;
                }
            }
            return result;
        }

        void dfs(int node) {
            if (states[node] == State.BLACK) {
                return;
            }

            if (states[node] == State.GREY) {
                result = true;
                return;
            }

            states[node] = State.GREY;

            var children = g[node];

            for (int child : children) {
                dfs(child);
            }

            states[node] = State.BLACK;
        }
    }

    public static class RemoveIslands {
        void remove(int[][] m) {
            for (int c = 0; c < m.length; c++) {
                remove(m, 0, c);
            }

            for (int c = m.length - 1; c < m.length; c++) {
                remove(m, m[0].length - 1, c);
            }

            for (int r = 0; r < m[0].length; r++) {
                remove(m, r, 0);
            }


            for (int r = 0; r < m[0].length; r++) {
                remove(m, r, m[0].length - 1);
            }

            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if (m[j][i] == 1) {
                        m[j][i] = 0;
                    }

                    if (m[j][i] == -1) {
                        m[j][i] = 1;
                    }
                }
            }
        }

        void remove(int[][] m, int r, int c) {
            if (r < 0 || r >= m[0].length) {
                return;
            }

            if (c < 0 || c >= m.length) {
                return;
            }

            if (m[r][c] != 1) {
                return;
            }

            m[r][c] = -1;

            remove(m, r - 1, c);
            remove(m, r + 1, c);
            remove(m, r, c - 1);
            remove(m, r, c + 1);
        }
    }

    public static class CommonAncestor {
        char n1;
        char n2;
        Node root;
        List<Character> p1;
        List<Character> p2;


        public CommonAncestor(char n1, char n2, Node graph) {
            this.n1 = n1;
            this.n2 = n2;
            this.root = graph;
        }

        char resolve() {
            var arr = new ArrayList<Character>();
            path(root, n1, arr, (xs) -> p1 = new ArrayList<>(xs));
            arr.clear();
            path(root, n2, arr, xs -> p2 = new ArrayList<>(xs));

            while (!p1.isEmpty() && !p2.isEmpty()) {
                if (p1.getLast() == p2.getLast()) {
                    return p1.getLast();
                }

                if (p1.size() > p2.size()) {
                    p1.removeLast();
                } else {
                    p2.removeLast();
                }
            }

            return '-';
        }

        void path(Node g, char target, List<Character> p, Consumer<List<Character>> fn) {
            if (g == null) {
                return;
            }

            p.add(g.val());
            if (g.val() == target) {
                fn.accept(p);
                return;
            }
            for (var child : g.children()) {
                path(child, target, p, fn);
            }
            p.removeLast();
        }
    }

    public static class RiverCount {
        int[][] matrix;
        int[][] visited;
        int curCount = 0;

        public RiverCount(int[][] m) {
            this.matrix = m;
            this.visited = new int[m.length][m[0].length];
        }

        List<Integer> resolve() {
            List<Integer> result = new ArrayList<>();
            for (int c = 0; c < matrix.length; c++) {
                for (int r = 0; r < matrix[c].length; r++) {
                    if (matrix[r][c] == 1 && visited[r][c] == 0) {
                        curCount = 0;
                        dfs(r, c);
                        result.add(curCount);
                    }
                }
            }

            return result;
        }

        void dfs(int r, int c) {
            if (r >= matrix.length || r < 0) {
                return;
            }

            if (c >= matrix[0].length || c < 0) {
                return;
            }

            if (matrix[r][c] == 0) {
                return;
            }

            if (visited[r][c] == 1) {
                return;
            }

            visited[r][c] = 1;
            curCount += 1;
            dfs(r + 1, c);
            dfs(r, c + 1);
            dfs(r - 1, c);
            dfs(r, c - 1);
        }
    }

    public static class SingleCycleCheck {
        int[] arr;
        int idx = 0;
        final Set<Integer> visited = new HashSet<>();

        public SingleCycleCheck(int[] arr) {
            this.arr = arr;
        }

        public boolean check() {
            int n;
            for (int i = 0; i < arr.length; i++) {
                n = arr[i];
                if (visited.contains(i)) {
                    return false;
                }
                visited.add(i);
                if (n > 0) {
                    forward(n);
                } else if (n < 0) {
                    backward(n);
                }
            }

            return visited.size() == arr.length;
        }

        private void forward(int n) {
            n = n % arr.length;
            idx = (idx + n) % arr.length;
        }

        private void backward(int n) {
            n = Math.abs(n) % arr.length;
            int d = idx - n;
            if (d < 0) {
                idx = arr.length - Math.abs(d);
            } else {
                idx = d;
            }
        }
    }

    static class WaysNum {

        int[][] dp;

        int ways(int w, int h) {
            dp = new int[h][w];
            for (var arr : dp) {
                Arrays.fill(arr, -1);
            }
            return ways(w, h, w, h);
        }

        int ways(int w, int h, int r, int c) {

            if (r == 1 && c == 1) {
                return 1;
            }

            if (r < 1 || r > w) {
                return 0;
            }

            if (c < 1 || c > h) {
                return 0;
            }

            if (dp[c - 1][r - 1] != -1) {
                return dp[c - 1][r - 1];
            }

            int left = ways(w, h, r, c - 1);
            int up = ways(w, h, r - 1, c);
            dp[c - 1][r - 1] = left + up;
            return left + up;
        }
    }

    static class MinNumOfCoins {

        int result(int val, int[] coins) {
            var dp = new int[val + 1];
            for (int curCoin : coins) {
                for (int j = 0; j < dp.length; j++) {
                    if (curCoin > j) {
                        continue;
                    } else {
                        int rest = j % curCoin;
                        int t = j / curCoin;
                        dp[j] = t + dp[rest];
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }

    static class NoAdjacent {

        int max(int[] arr) {
            int[] dp = new int[arr.length];
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                int m = 0;
                for (int j = i - 2; j >= 0; j--) {
                    m = Math.max(m, dp[j]);
                }

                dp[i] = Math.max(m + arr[i], arr[i]);
                result = Math.max(result, dp[i]);
            }

            return result;
        }
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
            int r = map.getOrDefault(node.right, 0);
            int sumLeft = allSum - l;
            int sumRight = allSum - sumLeft;
            if (sumLeft == sumRight) {
                result = sumLeft;
                return;
            }

            sumLeft = allSum - r;
            sumRight = allSum - sumLeft;
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
