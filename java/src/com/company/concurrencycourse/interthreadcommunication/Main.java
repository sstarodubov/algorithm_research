package com.company.concurrencycourse.interthreadcommunication;

public class Main {

    public static int counter = 0;

    public static void process() throws InterruptedException {
        var t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);

    }

    public static void main(String[] args) throws InterruptedException {
        process();
    }
}
