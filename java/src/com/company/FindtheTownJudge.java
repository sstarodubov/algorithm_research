package com.company;

/*
In a town, there are n people labelled from 1 to n.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindtheTownJudge {
    public static void main(String[] args) {
        var m = new FindtheTownJudge();
        assert -1 == m.findJudge(3, new int[][]{{1, 2}, {2, 3}}) : 99;
        assert 3 == m.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}) : 9;
        assert 2 == m.findJudge(2, new int[][]{{1, 2}}) : -1;
        assert -1 == m.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}) : 1;
        assert 3 == m.findJudge(3, new int[][]{{1, 3}, {2, 3}}) : 0;
        System.out.println("tests passed");
    }

    // Time O(n ^3) and Space O(n)
    public int findJudge(int n, int[][] trust) {
        var graph = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (var egde : trust) {
            List<Integer> integers = graph.get(egde[0]);
            integers.add(egde[1]);
        }

        for (var node : graph.entrySet()) {
            if (node.getValue().isEmpty()) {
                int c = 0;
                for (var m : graph.entrySet()) {
                    if (!m.getKey().equals(node.getKey())) {
                        if (m.getValue().contains(node.getKey())) c++;
                    }
                }
                if (c == n - 1) return node.getKey();
            }
        }

        return -1;
    }
}
