package haxul.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Flux<Object> flux = Flux.create(fluxSink -> {
            System.out.println("create " + Thread.currentThread().getName());
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        })
                .subscribeOn(Schedulers.boundedElastic())
                .doOnNext(i -> System.out.println("next " + i + " " + Thread.currentThread().getName()));

        flux
                .doFirst(() -> System.out.println(Thread.currentThread().getName()))
                .subscribe(v -> System.out.println("res " + Thread.currentThread().getName()));
        System.out.println("here");
        flux
                .doFirst(() -> System.out.println(Thread.currentThread().getName()))
                .subscribe(v -> System.out.println("res " + Thread.currentThread().getName()));
        System.out.println(start - System.currentTimeMillis());
        Thread.sleep(40000);
    }
}



