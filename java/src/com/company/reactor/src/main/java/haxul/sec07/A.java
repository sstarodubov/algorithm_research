package haxul.sec07;

import com.github.javafaker.IdNumber;
import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.LinkedList;

public class A {

    @SneakyThrows
    public static void main(String[] args) {
        var list = new LinkedList<>();
        Flux.create(fs -> {
                    for (int i = 0; i < 501; i++) {
                        fs.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fs.complete();
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                    }
                }).doOnComplete(() -> System.out.println(list))
                .subscribe(DefaultSubscriber.subscriber());

        Thread.sleep(10000000);

    }
}
