package haxul.sec09;

import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i)
                .buffer(5)
                .subscribe(DefaultSubscriber.subscriber());

        Flux.interval(Duration.ofMillis(300))
                .map(i -> "event: " + i)
                .window(5)
                .subscribe(DefaultSubscriber.subscriber());

        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i & 1)
                .subscribe(gf -> process(gf, gf.key()));


        Thread.sleep(100000);
    }

    private static void process(Flux<Integer> flux, int key) {
        flux.subscribe(i -> System.out.println("Key: " + key + ", Item: " + i));
    }
}
