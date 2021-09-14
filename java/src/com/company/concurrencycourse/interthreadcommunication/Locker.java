package com.company.concurrencycourse.interthreadcommunication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Livelock {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        var l = new Livelock();
        new Thread(l::worker1).start();
        new Thread(l::worker2).start();
    }

    public void worker1() {
        while (true) {
            System.out.println("working1");
            if (lock1.tryLock()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock2.tryLock()) {
                    break;
                }
            } else {
                lock1.unlock();
            }
        }
        lock1.unlock();
        lock2.unlock();
        System.out.println("finish 1");
    }

    public void worker2() {
        while (true) {
            System.out.println("working2");
            if (lock2.tryLock()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (lock1.tryLock()) {
                    break;
                }
            } else {
                lock2.unlock();
            }

        }
        lock2.unlock();
        lock1.unlock();
        System.out.println("finish 2");
    }
}

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

