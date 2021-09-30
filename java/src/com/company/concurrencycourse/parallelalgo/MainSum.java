package com.company.concurrencycourse.parallelalgo;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MainSum {
    public static void main(String[] args) {

        var r = new Random();
        var n = 1_000_000_000;
        var nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = r.nextInt(1500);
        }

        var start = System.nanoTime();
        var parSum = new ParSum();
        parSum.sum(nums);

        System.out.println("Paral " + (System.nanoTime() - start));

        var start2 = System.nanoTime();
        var seq = new SeqSum();

        seq.sum(nums);
        System.out.println("Seq " + (System.nanoTime() - start2));
    }
}

class ParSum {

    int nThreads = 8;

    public long sum(int[] nums) {
        var futures = new ArrayList<Future<Long>>();
        var step = nums.length / nThreads;
        var pool = Executors.newFixedThreadPool(8);
        int l = 0;
        int r = step;

        for (int i = 0; i < nThreads; i++) {
            if (r >= nums.length) {
                r = nums.length - 1;
                int finalL1 = l;
                int finalR1 = r;
                Future<Long> future = pool.submit(() -> compute(nums, finalL1, finalR1));
                futures.add(future);
                continue;
            }
            int finalL = l;
            int finalR = r;
            Future<Long> future = pool.submit(() -> compute(nums, finalL, finalR));
            futures.add(future);
            l = r + 1;
            r = r + step;
        }
        var sums = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());

        pool.shutdown();
        long total = 0;
        for (var sum : sums) {
            total += sum;
        }

        return total;
    }

    private long compute(int[] nums, int left, int right) {
        long total = 0;
        for (int i = left; i <= right; i++) {
            total += nums[i];
        }
        return total;
    }
}


class SeqSum {
    public long sum(int[] nums) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}