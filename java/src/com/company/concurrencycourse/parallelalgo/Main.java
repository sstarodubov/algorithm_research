package com.company.concurrencycourse.parallelalgo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        int len = 100000000;
        var ints = new int[len];
        var r = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < len; i++) {
            ints[i] = r.nextInt(1500);
        }
        var m = new Mergesort(ints);
        m.parallelMergesort(0, ints.length - 1);
        System.out.println(System.nanoTime() - start);
    }
}


class Mergesort {

    private final int[] nums;
    private final int[] tmpArr;
    private final AtomicInteger nThreads = new AtomicInteger(8);
    public final ExecutorService poll = Executors.newFixedThreadPool(8);


    public Mergesort(int[] nums) {
        this.nums = nums;
        this.tmpArr = new int[nums.length];
    }

    public void parallelMergesort(int low, int high) {
        if (nThreads.intValue() <= 1) {
            mergesort(low, high);
            return;
        }

        if (low >= high) return;

        int middle = (low + high) / 2;
        var lt = CompletableFuture.runAsync(() -> {
            nThreads.decrementAndGet();
            parallelMergesort(low, middle);
        }, poll);
        var rt = CompletableFuture.runAsync(() -> {
            nThreads.decrementAndGet();
            parallelMergesort(middle + 1, high);
        }, poll);

        lt.join();
        rt.join();

        merge(low, middle, high);
    }

    public void mergesort(int low, int high) {
        if (low >= high) return;
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);

        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            tmpArr[i] = nums[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (tmpArr[i] <= tmpArr[j]) {
                nums[k] = tmpArr[i];
                i++;
            } else {
                nums[k] = tmpArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            nums[k] = tmpArr[i];
            i++;
            k++;
        }

        while (j <= high) {
            nums[k] = tmpArr[j];
            j++;
            k++;
        }
    }
}