package haxul.sec04;

import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class HandleSec {
    public static void main(String[] args) throws InterruptedException {
//        Flux.range(1, 20)
//                .handle(((integer, synchronousSink) -> {
//                    if ((integer & 1) == 1) synchronousSink.next(integer);
//                    if (integer == 15) synchronousSink.complete();
//                }))
//                .subscribe(System.out::println);

//        Flux.generate(sink -> sink.next(Faker.instance().country().name()))
//                .map(Object::toString)
//                .handle((s, sink) -> {
//                    sink.next(s);
//                    if (s.equals("Canada")) sink.complete();
//                }).subscribe(e -> System.out.println(e));

//        Flux.create(fluxSink -> {
//                    System.out.println("inside");
//                    for (int i = 0; i < 10; i++) {
//                        fluxSink.next(i);
//                    }
//                    fluxSink.complete();
//                    System.out.println("Complete");
//                }).doOnComplete(() -> System.out.println("hello completeed"))
//                .doFirst(() -> System.out.println("do first"))
//                .doOnNext(o -> System.out.println(o + " do on next"))
//                .doOnSubscribe(s -> System.out.println(" on subs " + s))
//                .doOnRequest(l -> System.out.println("do on request " + l))
//                .doOnError(err -> System.out.println(err.getMessage() + " do on error"))
//                .doOnTerminate(() -> System.out.println("do on terminate"))
//                .doOnComplete(() -> System.out.println(" do on complete"))
//                .doFinally((signal) -> System.out.println(" do on finally " + signal))
//                .doOnDiscard( Object.class, el -> System.out.println(" do on discard " + el))
//                .subscribe(System.out::println);

//        Flux.range(1, 10)
//                .log()
//                .limitRate(2)
//                .subscribe(System.out::println);

//        Flux.range(1, 100)
//                .log()
//                .delayElements(Duration.ofSeconds(1))
//                .subscribe(integer -> System.out.println(integer));

//        Flux.range(1, 20)
//                .map(el -> {
//                    if (el == 10) throw new RuntimeException("hoho");
//                    return el;
//                })
////                .onErrorReturn(-100)
////                .onErrorResume(e -> fallback())
//                .onErrorContinue((err, ob) -> {
//                    System.out.println(ob);
//                    System.out.println(err);
//                })
//                .subscribe(el -> System.out.println(el),
//                        err -> System.out.println(err.getMessage()),
//                        () -> System.out.println("complete"));

//        getOrderNumber()
//                .timeout(Duration.ofSeconds(2), fallback())
//                .subscribe(e -> System.out.println(e));
//        Thread.sleep(60000);

        getOrderNumber()
                .filter(i -> i > 100)
                .defaultIfEmpty(-100)
                .subscribe(System.out::println,
                        System.out::println,
                        () -> System.out.println("completed"));
    }


    private static Flux<Integer> fallback() {
        return Flux.range(100, 10);
    }

    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1, 20);
    }
//
//    private static Mono<Integer> fallback() {
//        return Mono.fromSupplier(() -> Faker.instance().random().nextInt(100));
//    }
}
