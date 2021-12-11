package com.haxul.springtest.controller;

import org.reactivestreams.Subscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TestController {
    public final ExecutorService pool = Executors.newSingleThreadExecutor();

    @GetMapping("/test")
    public String test() {
        System.out.println("start");
        Disposable subscribe = httpRequest()
                .subscribeOn(Schedulers.fromExecutor(pool))
                .limitRate(4)
                .subscribe(
                        (v) -> {
                            System.out.println(v);
                            System.out.println(Thread.currentThread().getName());
                        },
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("done on " + Thread.currentThread().getName());
                        }
                );

        System.out.println("end");
        return "hello";
    }

    public static Flux<String> httpRequest() {
        return Flux.create((synchronousSink) -> {
            for (int i = 0; i < 10; i++) {
                var r = new RestTemplate();
                ResponseEntity<String> forEntity = r.getForEntity("https://httpbin.org/get", String.class);
                synchronousSink.next(i + " === > " + forEntity.getBody());
            }
            synchronousSink.complete();
        });
    }
}


class CustomSub extends BaseSubscriber<String> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        subscription.request(1);
    }
}


class Main {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4)
                .subscribe(new BaseSubscriber<>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        subscription.request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println(value);
                        cancel();
                    }
                });
    }
}

