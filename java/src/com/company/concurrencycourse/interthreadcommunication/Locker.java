package com.company.concurrencycourse.interthreadcommunication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locker {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    public static void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    increment();
                } finally {
                    lock.unlock();
                }
            }
        });
        var t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    increment();
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter);
    }
}

