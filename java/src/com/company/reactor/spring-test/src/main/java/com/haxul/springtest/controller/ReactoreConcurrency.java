package com.haxul.springtest.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ReactoreConcurrency {
}


class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> {
                    System.out.println("map1 " + Thread.currentThread().getName());
                    return 10 + i;
                })
                .subscribeOn(s)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("map1 " + Thread.currentThread().getName());
                    return "value " + i;
                });

        var t = new Thread(() -> flux.subscribe(el -> {
            System.out.println("first " + Thread.currentThread().getName());
            System.out.println(el);
        }));
        t.start();
        Thread.sleep(10000);
    }
}

