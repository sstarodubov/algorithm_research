package haxul.sec08;

import com.github.javafaker.Faker;
import haxul.sec03.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

//        final NameGenerator nameGenerator = new NameGenerator();
//        nameGenerator.generateNames()
//                .take(2)
//                .subscribe(DefaultSubscriber.subscriber("test"));
//        nameGenerator.generateNames()
//                .take(2)
//                .subscribe(DefaultSubscriber.subscriber("mickel"));
//        Flux.concatDelayError()

        Flux<Integer> merge = Flux.merge(Flux.range(1, 10), Flux.range(10, 10));
        merge.subscribe(DefaultSubscriber.subscriber());
    }
}

class NameGenerator {

    List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(s -> {
                    final String name = Faker.instance().name().firstName();
                    list.add(name);
                    s.next(name);
                }).cast(String.class)
                .startWith(getFromCache());
    }

    public Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}