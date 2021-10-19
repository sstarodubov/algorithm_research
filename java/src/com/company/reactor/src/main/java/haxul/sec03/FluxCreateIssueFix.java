package haxul.sec03;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {
    @SneakyThrows
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            var country = Faker.instance().country().name();
            while (!country.equals("Canada") && !fluxSink.isCancelled()) {
                System.out.println(Thread.currentThread().getName() + " emit " + country);
                fluxSink.next(country);
                country = Faker.instance().country().name();
            }
            fluxSink.complete();
        });

        flux.take(3)
                .subscribeWith(DefaultSubscriber.subscriber("h"));
        flux.subscribeWith(DefaultSubscriber.subscriber("b"));
    }
}
