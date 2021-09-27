package com.company.concurrencycourse.philisoferproblems;

import java.util.Random;

public class Philosopher implements Runnable {

    public int id;
    public volatile boolean isFull;
    public Chopstick left;
    public Chopstick right;
    private Random random;
    public int eatingCounter;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!isFull) {
                think();
                if (left.pickUp(this, State.LEFT)) {
                    if (right.pickUp(this, State.RIGHT)) {
                        eat();
                        right.putDown(this, State.RIGHT);
                    }
                    left.putDown(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void think() throws InterruptedException {
        System.out.println(this + " is thinking...");
        Thread.sleep(random.nextInt(1000));
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " is eating...");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
