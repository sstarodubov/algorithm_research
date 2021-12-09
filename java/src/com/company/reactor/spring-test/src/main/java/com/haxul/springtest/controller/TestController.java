package com.haxul.springtest.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TestController {
    public ExecutorService pool = Executors.newSingleThreadExecutor();
    @GetMapping("/test")
    public String test() {

        httpRequest()
                .subscribeOn(Schedulers.fromExecutor(pool))
                .subscribe(
                        System.out::println,
                        Throwable::printStackTrace,
                        () -> {
                            System.out.println("done on " + Thread.currentThread().getName());
                        }
                );
        return "hello";
    }

    public static Mono<String> httpRequest() {
        return Mono.fromSupplier(() -> {
            var r = new RestTemplate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ResponseEntity<String> forEntity = r.getForEntity("https://httpbin.org/get", String.class);
            return forEntity.getBody();
        });
    }
}



