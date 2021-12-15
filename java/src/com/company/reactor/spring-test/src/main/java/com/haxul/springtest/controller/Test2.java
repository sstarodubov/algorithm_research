package com.haxul.springtest.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        var db = new Db();

        var flux = Flux.range(0, 5)
                .publishOn(Schedulers.boundedElastic())
                .filter(i -> (i & 1) == 0)
                .flatMap(db::find)
                .map(i -> " got: " + i + " " + Thread.currentThread().getName());


        flux
                .publishOn(Schedulers.immediate())
                .subscribe(a -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(a);
                });

        Thread.sleep(10000);
    }
}


class Db {
    public final ConcurrentHashMap<Integer, String> db = new ConcurrentHashMap<>(Map.of(
            3, "hello",
            4, "world"
    ));

    public Mono<String> find(int num) {
        return Mono.fromSupplier(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return db.get(num);
        });
    }
}
