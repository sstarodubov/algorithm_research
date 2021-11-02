package haxul.sec09;

import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
//        Flux.interval(Duration.ofMillis(300))
//                .map(i -> "event " + i)
//                .buffer(5)
//                .subscribe(DefaultSubscriber.subscriber());

        Flux.interval(Duration.ofMillis(300))
                .map(i -> "event: " + i)
                .window(5)
                .subscribe(DefaultSubscriber.subscriber());


        Thread.sleep(100000);
    }
}
