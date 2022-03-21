package com.company.leetcode.E1122;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        var arr2m = new HashMap<Integer, Integer>();
        for (int n : arr2) {
            arr2m.put(n, 0);
        }
        var un = new LinkedList<Integer>();
        for (int n : arr1) {
            if (arr2m.containsKey(n)) {
                int val = arr2m.get(n);
                arr2m.put(n, val + 1);
            } else {
                un.add(n);
            }
        }

        var ans = new int[arr1.length];
        int ptr = 0;
        for (int j : arr2) {
            if (arr2m.containsKey(j)) {
                while (arr2m.get(j) != 0) {
                    ans[ptr] = j;
                    int c = arr2m.get(j);
                    arr2m.put(j, c - 1);
                    ptr++;
                }
            }
        }
        un.sort(Comparator.reverseOrder());
        for (int i = ptr; i < ans.length; i++) {
            Integer integer = un.removeLast();
            ans[i] = integer;
        }
        return ans;
    }
}
