package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Task extends RecursiveTask<Integer> {

    private final List<Integer> arr;

    public Task(List<Integer> arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.size() < 100) {
            int sum = 0;
            for (Integer integer : arr) {
                sum += integer;
            }
            return sum;
        }


        int md = arr.size() / 2;

        var lSum = new Task(arr.subList(0, md));
        var rSum = new Task(arr.subList(md, arr.size()));

        lSum.fork();
        rSum.fork();


        return lSum.join() + rSum.join();
    }
}

public class Main {
    public static void main(String[] args) {
        int a = 1_000_000000;
        var ints = IntStream.range(1, a).boxed().toList();
        var pool = new ForkJoinPool(3);

        Integer invoke = pool.invoke(new Task(ints));
        System.out.println(invoke);
    }
}
