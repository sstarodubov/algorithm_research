package com.company.neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class M739 {

    public static void main(String[] args) {
        var t = new int[] {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(new M739().dailyTemperatures(t)));
    }

    record Pair(int idx, int tmp) {
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        var ret = new int[n];
        var stack = new ArrayDeque<Pair>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(i, temperatures[i]));
            } else {
                if (stack.peek().tmp >= temperatures[i]) {
                    stack.push(new Pair(i, temperatures[i]));
                } else {
                    while (!stack.isEmpty() && stack.peek().tmp < temperatures[i]) {
                        var pop = stack.pop();
                        ret[pop.idx] = i - pop.idx;
                    }

                    stack.push(new Pair(i, temperatures[i]));
                }
            }
        }

        return ret;
    }
}
