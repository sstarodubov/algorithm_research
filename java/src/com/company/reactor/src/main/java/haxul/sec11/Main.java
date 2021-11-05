package haxul.sec11;

import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        // mono
//        Sinks.One<Integer> sink = Sinks.one();
//        sink.tryEmitValue(11);
//        sink.asMono().subscribe(DefaultSubscriber.subscriber());

//        Sinks.Many<Integer> sink = Sinks.many().multicast().onBackpressureBuffer();
//
//        sink.asFlux().subscribe(DefaultSubscriber.subscriber("andrey"));
//
//        sink.tryEmitNext(10);
//        sink.asFlux().subscribe(DefaultSubscriber.subscriber("sergei"));
//        sink.tryEmitNext(11);
//        sink.tryEmitNext(12);
//        sink.tryEmitComplete();
        Sinks.Many<Integer> sink = Sinks.many().unicast().onBackpressureBuffer();
        var list = new ArrayList<Integer>();

        sink.asFlux().subscribe(list::add);


        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(() -> {
                sink.emitNext(j, (signalType,h)-> {
                    System.out.println(signalType.name());
                    System.out.println(h.name());
                    return true;
                });
            });
        }


        Thread.sleep(4000);
        System.out.println(list.size());
    }
}
