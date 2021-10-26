package haxul.sec05;

import haxul.sec03.DefaultSubscriber;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class ColdPublisher {

    @SneakyThrows
    public static void main(String[] args) {
        Flux<String> flux = Flux.fromStream(ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(1));

        flux.subscribe(DefaultSubscriber.subscriber("hello"));
        flux.subscribe(DefaultSubscriber.subscriber("world"));

        Thread.sleep(10000);
    }

    public static Stream<String> getMovie() {
        System.out.println("got the movie");
        return Stream.of(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7"
                );
    }
}

class HotPublisher {


    @SneakyThrows
    public static void main(String[] args) {
        Flux<String> flux = Flux.fromStream(ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .share();

        flux.subscribe(DefaultSubscriber.subscriber("hello"));
        Thread.sleep(2000);
        flux.subscribe(DefaultSubscriber.subscriber("world"));

        Thread.sleep(10000);
    }
}