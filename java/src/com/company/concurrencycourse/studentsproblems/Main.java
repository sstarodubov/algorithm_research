package com.company.concurrencycourse.studentsproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Book[] books = new Book[8];
        Student[] students = new Student[4];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(i);
        }
        for (int i = 0; i < 4; i++) {
            students[i] = new Student(i, books);
        }

        for (Student s : students) {
            es.execute(s);
        }

        es.shutdown();
        Thread.sleep(5000);

        for (Student s : students) {
            s.stop();
        }

        es.awaitTermination(1, TimeUnit.HOURS);

    }
}
