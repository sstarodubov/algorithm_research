package haxul.sec03;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxGeneraterMain {
    public static void main(String[] args) {
        Flux<Object> generate = Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.complete();
        });
//
        generate
                .subscribeWith(DefaultSubscriber.subscriber("df"));

//        Flux.generate(() -> 1, (state, sink) -> {
//            String name = Faker.instance().country().name();
//            sink.next(name);
//            if (name.equals("Canada") || state > 10) sink.complete();
//            return state + 1;
//        }).subscribeWith(DefaultSubscriber.subscriber());
    }
}
