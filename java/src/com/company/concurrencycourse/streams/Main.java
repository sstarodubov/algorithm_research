package com.company.concurrencycourse.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
//        final String path = "/home/haxul/Development/workspaces/java/algorithm_tasks_solving/java/src/com/company/concurrencycourse/streams/text.txt";
//        Files.lines(Path.of(path)).forEach(System.out::println);

        var pool = new ForkJoinPool(8);
        ForkJoinTask<Integer> submit = pool.submit(new ComputeDoubleTask(0, 8, List.of(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 0.8)));
        Integer result = submit.join();
        System.out.println(result);

    }
}


class ComputeDoubleTask extends RecursiveTask<Integer> {

    private final int r;
    private final List<Double> arr;
    private final int l;

    public ComputeDoubleTask(int l, int r, List<Double> arr) {
        this.l = l;
        this.r = r;
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (l >= r) {
            var el = arr.get(l);
            return el > 0.5 ? 1 : 0;
        }

        int middle = (r + l) / 2;
        var lTask = new ComputeDoubleTask(l, middle, arr);
        var rTask = new ComputeDoubleTask(middle + 1, r, arr);
        invokeAll(lTask, rTask);

        final Integer lans = lTask.join();
        final Integer rans = rTask.join();

        return lans + rans;
    }
}