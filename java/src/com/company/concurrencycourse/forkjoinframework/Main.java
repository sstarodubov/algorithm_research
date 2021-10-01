package com.company.concurrencycourse.forkjoinframework;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) throws Exception {
        var pool = new ForkJoinPool(8);
        List<Integer> invoke = pool.invoke(new MergeSortTask(List.of(5, 4, 3, 2, 1)));
        System.out.println(invoke);
    }
}

class MergeSortTask extends RecursiveTask<List<Integer>> {

    private final List<Integer> xs;

    public MergeSortTask(List<Integer> xs) {
        this.xs = xs;
    }

    @Override
    protected List<Integer> compute() {
        if (xs.size() <= 1) return xs;

        int middle = xs.size() / 2;
        var lt = new MergeSortTask(xs.subList(0, middle));
        var rt = new MergeSortTask(xs.subList(middle, xs.size()));

        lt.fork();
        rt.fork();

        List<Integer> lj = lt.join();
        List<Integer> rj = rt.join();

        return merge(lj, rj);
    }

    private List<Integer> merge(List<Integer> xs, List<Integer> ys) {
        int lptr = 0;
        int rptr = 0;
        var result = new LinkedList<Integer>();
        while (lptr < xs.size() && rptr < ys.size()) {
            if (xs.get(lptr) < ys.get(rptr)) {
                result.add(xs.get(lptr));
                lptr++;
            } else {
                result.add(ys.get(rptr));
                rptr++;
            }
        }

        while (rptr < ys.size()) {
            result.add(ys.get(rptr));
            rptr++;
        }

        while (lptr < xs.size()) {
            result.add(xs.get(lptr));
            lptr++;
        }
        return result;
    }
}


class FindMaxTask extends RecursiveTask<Integer> {

    private final List<Integer> xs;
    private final int l;
    private final int r;

    public FindMaxTask(final List<Integer> xs, final int l, final int r) {
        this.xs = xs;
        this.l = l;
        this.r = r;
    }

    @Override
    protected Integer compute() {
        if (l >= r) return xs.get(l);

        var middle = (l + r) / 2;
        var lt = new FindMaxTask(xs, l, middle);
        var rt = new FindMaxTask(xs, middle + 1, r);

        lt.fork();
        rt.fork();

        Integer lMax = lt.join();
        Integer rMax = rt.join();

        return Math.max(lMax, rMax);
    }
}

class TwoSumTask extends RecursiveTask<Integer> {

    private final List<List<Integer>> xs;
    private final int left;
    private final int right;

    public TwoSumTask(List<List<Integer>> xs, int l, int r) {
        this.left = l;
        this.right = r;
        this.xs = xs;
    }

    @Override
    protected Integer compute() {
        if (left >= right) return xs.get(left).stream().mapToInt(Integer::intValue).sum();

        final int middle = (left + right) / 2;
        var lTask = new TwoSumTask(xs, left, middle);
        var rTask = new TwoSumTask(xs, middle + 1, right);

        lTask.fork();
        rTask.fork();

        Integer lj = lTask.join();
        Integer rj = rTask.join();

        return lj + rj;
    }
}


class ReturnTask extends RecursiveTask<Integer> {

    private final int[] nums;
    private final int l;
    private final int h;

    public ReturnTask(int[] nums, int l, int h) {
        this.nums = nums;
        this.l = l;
        this.h = h;
    }

    @Override
    protected Integer compute() {
        if (l >= h) return nums[l];

        int middle = (l + h) / 2;
        var left = new ReturnTask(nums, l, middle);
        var right = new ReturnTask(nums, middle + 1, h);

        left.fork();
        right.fork();

        Integer lJoin = left.join();
        Integer rJoin = right.join();

        return lJoin + rJoin;
    }
}


class SimpleTask extends RecursiveAction {

    private final int simulatedWork;

    public SimpleTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split task.."
                    + simulatedWork);
            SimpleTask st1 = new SimpleTask(simulatedWork / 2);
            SimpleTask st2 = new SimpleTask(simulatedWork / 2);

            st1.fork();
            st2.fork();

        } else {
            System.out.println("no need for parallel execution .." +
                    simulatedWork);
        }
    }
}