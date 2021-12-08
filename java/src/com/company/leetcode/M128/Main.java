package com.company.leetcode.M128;




import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        assert 9 == new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        assert 3 == new Solution().longestConsecutive(new int[]{1, 2, 0, 1});
        assert 4 == new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println("tests passed");
    }
}

class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        var unionFind = new UnionFind(nums.length);
        for (var num : map.keySet()) {
            if (map.containsKey(num - 1)) unionFind.unify(map.get(num), map.get(num - 1));
            if (map.containsKey(num + 1)) unionFind.unify(map.get(num), map.get(num + 1));
        }
        map.clear();
        int ans = 0;
        for (var id : unionFind.id) {
            if (map.containsKey(id)) map.put(id, map.get(id) + 1);
            else map.put(id, 1);
            ans = Math.max(ans, map.get(id));
        }
        return ans;
    }
}

class UnionFind {

    private final int[] sz;
    public final int[] id;


    public UnionFind(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        sz = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2) return;

        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }
    }

}
