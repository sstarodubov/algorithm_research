package com.company.concurrencycourse.collections;

import java.util.concurrent.Exchanger;

public class Обменник {
    public static void main(String[] args) {
        var exchanger = new Exchanger<Integer>();
        new Thread(new WorkerFirst(exchanger)).start();
        new Thread(new WorkerSecond(exchanger)).start();
    }
}

class WorkerFirst implements Runnable {

    public int counter;
    public Exchanger<Integer> exchanger;

    public WorkerFirst(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            counter += 1;

            try {
                Thread.sleep(1000);
                System.out.println("WorkerFirst add " + counter);
                counter = exchanger.exchange(counter);
                System.out.println("workerFirst one cycle");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WorkerSecond implements Runnable {

    public int counter;
    public Exchanger<Integer> exchanger;

    public WorkerSecond(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {

            counter -= 1;
            try {
                Thread.sleep(5000);
                System.out.println("WorkerSecond remove " + counter);
                counter = exchanger.exchange(counter);
                System.out.println("WorkerSecond cycle");
            } catch (InterruptedException e) {

            }
        }
    }
}