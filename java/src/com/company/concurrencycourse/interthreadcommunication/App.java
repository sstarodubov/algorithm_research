package com.company.concurrencycourse.interthreadcommunication;

import java.util.ArrayList;
import java.util.List;

class Producer {
    private int value = 0;
    private final Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (App.LIST.size() == App.UPPER_LIMIT) {
                    System.out.println("waiting for removing items");
                    lock.wait();
                } else {
                    Thread.sleep(100);
                    System.out.println("Adding: " + value);
                    App.LIST.add(value);
                    value++;
                    lock.notify();
                }
            }
        }
    }
}

class Consumer {
    private final Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (App.LIST.size() == App.LOWER_LIMIT) {
                    System.out.println("consumer is waiting ...");
                    lock.wait();
                } else {
                    Thread.sleep(800);
                    System.out.println("Remove: " + App.LIST.get(App.LIST.size() - 1));
                    App.LIST.remove(App.LIST.size() - 1);
                    lock.notifyAll();
                }
            }
        }
    }
}

public class App {

    public static final int UPPER_LIMIT = 5;
    public static final List<Integer> LIST = new ArrayList<>();
    public static final int LOWER_LIMIT = 0;

    public static void main(String[] args) throws InterruptedException {
        var plock = new Object();
        var c = new Consumer(plock);
        var p = new Producer(plock);

        var t1 = new Thread(() -> {
            try {
                c.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        var t2 = new Thread(() -> {
            try {
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
