package haxul.sec05;

import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Another {


    @SneakyThrows
    public static void main(String[] args) {

        Flux<Integer> flux = Flux.range(1, 10)
                .delayElements(Duration.ofMillis(500))
                .publish()
                .autoConnect(1);

        flux.subscribe(DefaultSubscriber.subscriber("sam"));
        Thread.sleep(2000);
        flux.subscribe(DefaultSubscriber.subscriber("john"));
        Thread.sleep(100000);
    }
}
