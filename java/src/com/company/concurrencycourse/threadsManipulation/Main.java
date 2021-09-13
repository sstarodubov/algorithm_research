package com.company.concurrencycourse.threadsManipulation;

import java.util.concurrent.FutureTask;

interface Runner {
    void execution();
}

class Runner1 implements Runner, Runnable {

    @Override
    public void execution() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runner1: " + i);
        }
    }

    @Override
    public void run() {
        execution();
    }
}

class Runner2 implements Runner, Runnable {

    @Override
    public void execution() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runner2: " + i);
        }
    }

    @Override
    public void run() {
        execution();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var t = new Thread(() -> {
            while (true) {
                System.out.println("hello from " + Thread.currentThread().getName());
            }
        });

        t.setDaemon(true);
        t.start();

        Thread.sleep(1000);
        System.out.println("fidni");
    }
}
