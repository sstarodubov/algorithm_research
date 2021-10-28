package haxul.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    System.out.println("create " + Thread.currentThread().getName());
                    for (int i = 0; i < 40; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> System.out.println("next " + i + " " + Thread.currentThread().getName()));

        flux
                .subscribe(v -> System.out.println("res " + Thread.currentThread().getName()));

        Thread.sleep(40000);
    }
}



