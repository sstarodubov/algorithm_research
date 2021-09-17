package com.company.concurrencycourse.exectorframework;


import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("done id " + id);
    }
}

public class Main {

//    public static void main(String[] args) {
//        var sext = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 5; i++) {
//            sext.execute(new Task(i));
//        }
//    }

    public static void main(String[] args) {
        var tp = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            tp.execute(new Task(i));
        }

        tp.shutdown();

        try {
            if (!tp.awaitTermination(2, TimeUnit.SECONDS)) {
                tp.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        var stp = Executors.newScheduledThreadPool(1);
//        stp.scheduleAtFixedRate(new Task(1), 0, 1, TimeUnit.SECONDS);
//
//    }
}
