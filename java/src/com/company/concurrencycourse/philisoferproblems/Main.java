package com.company.concurrencycourse.philisoferproblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService es = null;
        Philosopher[] philosophers = null;
        Chopstick[] chopsticks;
        try {
            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
            chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPSTICKS];
            for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
                chopsticks[i] = new Chopstick(i);
            }
            es = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);

            for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICKS]);
                es.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
            for (Philosopher p : philosophers) {
                p.isFull = true;
            }

        } finally {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.HOURS);

            for (Philosopher p : philosophers) {
                System.out.println(p + " eat# " + p.eatingCounter + "times");
            }
        }
    }
}
