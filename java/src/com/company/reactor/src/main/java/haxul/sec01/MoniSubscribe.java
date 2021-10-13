package haxul.sec01;

import reactor.core.publisher.Mono;

import java.util.function.Consumer;

class Util {
    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return o -> System.out.println("Thrown: " + o);
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Complete");
    }
}

public class MoniSubscribe {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::toUpperCase)
                .map(String::length)
                .map(l -> l / 0);


        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("complete")
        );

    }
}
