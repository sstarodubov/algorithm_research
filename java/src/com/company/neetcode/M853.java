package com.company.neetcode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class M853 {

    record Pair(double pos, double speed) implements Comparable<Pair> {

        @Override
        public int compareTo(@NotNull Pair o) {
            if (this.pos != o.pos) {
                return (int) (o.pos - pos);
            }

            return (int) (o.speed - speed);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        var pairs = new ArrayList<Pair>(n);
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(pairs);
        var dq = new ArrayList<Double>();

        for (int i = 0; i < n; i++) {
            var p = pairs.get(i).pos;
            var s = pairs.get(i).speed;

            dq.add((target - p) /  s);
            if (dq.size() >= 2 && dq.getLast() <= dq.get(dq.size() - 2)) {
                dq.removeLast();
            }
        }

        return dq.size();

    }
}
