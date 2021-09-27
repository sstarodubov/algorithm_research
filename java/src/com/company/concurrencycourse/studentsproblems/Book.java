package com.company.concurrencycourse.studentsproblems;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    public int id;
    public Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock(true);
    }

    public boolean tryTake(Student s) throws InterruptedException {
        if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
            System.out.println(s + " took the book " + this);
            return true;
        }
        return false;
    }

    public void takeBack(Student s) {
        lock.unlock();
        System.out.println(s + "took back " + this);
    }

    @Override
    public String toString() {
        return "Book(id=" + id + ")";
    }
}
