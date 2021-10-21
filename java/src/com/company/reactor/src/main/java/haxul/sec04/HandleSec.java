package haxul.sec04;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class HandleSec {
    public static void main(String[] args) {
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

        Flux.create(fluxSink -> {
                    System.out.println("inside");
                    for (int i = 0; i < 10; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("Complete");
                }).doOnComplete(() -> System.out.println("hello completeed"))
                .doFirst(() -> System.out.println("do first"))
                .doOnNext(o -> System.out.println(o + " do on next"))
                .doOnSubscribe(s -> System.out.println(" on subs " + s))
                .doOnRequest(l -> System.out.println("do on request " + l))
                .doOnError(err -> System.out.println(err.getMessage() + " do on error"))
                .doOnTerminate(() -> System.out.println("do on terminate"))
                .doOnComplete(() -> System.out.println(" do on complete"))
                .doFinally((signal) -> System.out.println(" do on finally " + signal))
                .doOnDiscard( Object.class, el -> System.out.println(" do on discard " + el))
                .subscribe(System.out::println);
    }
}
