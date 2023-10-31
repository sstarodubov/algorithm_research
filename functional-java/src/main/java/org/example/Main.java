package org.example;

import java.util.Scanner;
import java.util.concurrent.Executors;

public class Main {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        var pool = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i <2 ; i++) {
            int finalI = i;
            pool.execute(() -> {
                threadLocal.set(finalI);
                var v = threadLocal.get();
                System.out.println(v);
            });
        }


        var v = new Scanner(System.in).nextByte();
    }
}

