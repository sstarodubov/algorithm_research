package com.company.concurrencycourse.studentsproblems;

import java.util.Random;

public class Student implements Runnable {

    public int id;
    public Random random;
    public Book[] books;
    public volatile boolean stopped = false;

    public Student(int id, Book[] books) {
        this.id = id;
        this.random = new Random();
        this.books = books;
    }

    @Override
    public void run() {
        while (!stopped) {
            for (Book b : books) {
                try {
                    if (b.tryTake(this)) {
                        read(b);
                        b.takeBack(this);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        stopped = true;
    }

    private void read(Book book) throws InterruptedException {
        System.out.println(this + " is reading " + book);
        Thread.sleep(random.nextInt(2500));
    }

    private void takeBack(Book book) {
        System.out.println(this + " took back " + book);
    }


    @Override
    public String toString() {
        return "Student(id=" + id + ")";
    }
}
