package com.company.concurrencycourse.collections;


import java.util.Formatter;
import java.util.Random;
import java.util.concurrent.*;

class Worker implements Runnable {

    private final int id;
    private Random random;
    private final CyclicBarrier barrier;

    public Worker(int id, CyclicBarrier barrier) {
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("thread with id " + id + " starts");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread with id " + id + " finish");
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            try {
                System.out.println("put item in queue: " + num);
                queue.put(num);
                num++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {


            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer num = queue.take();
                System.out.println("take item in queue: " + num);
                System.out.println("q size: " + queue.size());
                Thread.sleep(2000);
            } catch (InterruptedException e) {


            }

        }
    }
}

public class Main {

    public static void main(String[] args) {
        var bq = new ArrayBlockingQueue<Integer>(10);
        var consumer = new Consumer(bq);
        var producer = new Producer(bq);

        new Thread(consumer).start();
        new Thread(producer).start();
    }
//    public static void main(String[] args) {
//        var threadPool = Executors.newFixedThreadPool(1);
//        var barrier = new CyclicBarrier(5, () -> {
//            System.out.println("all tasks are finished");
//        });
//
//        for (int i = 0; i < 5; i++) {
//            threadPool.execute(new Worker(i, barrier));
//        }
//    }
}
//    public static void main(String[] args) throws InterruptedException {
//        var list = Collections.synchronizedList(new ArrayList<Integer>());
//
//        var t1 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                list.add(i);
//            }
//        });
//
//        var t2 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                list.add(i);
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println(list.size());
//    }

