package haxul.sec10;

import haxul.sec03.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed"))
                .doOnComplete(() -> System.out.println("Completed"))
                .repeat(2)
                .subscribe(DefaultSubscriber.subscriber());


    }

    private static AtomicInteger aint = new AtomicInteger(0);
}
