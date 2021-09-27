package com.company.concurrencycourse.philisoferproblems;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    public int id;
    public Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public Chopstick(int id, Lock lock) {
        this.lock = lock;
        this.id = id;
    }

    public boolean pickUp(Philosopher p, State s) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(p + " picked up " + s.toString() + " " + this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher p, State s) {
        lock.unlock();
        System.out.println(p + " put down " + s.toString() + " " + this);

    }

    @Override
    public String toString() {
        return "Chopstick: " +
                "id=" + id;
    }
}
