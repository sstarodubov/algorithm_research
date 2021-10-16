package haxul.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Interv {
    public static void main(String[] args) throws InterruptedException {
//        Flux.interval(Duration.ofSeconds(1))
//                .subscribe(f -> System.out.println(f));
//
        Mono<String> mono = Mono.just("hell");
        Flux<String> flux = Flux.from(mono);
        Mono<Integer> from = Mono.from(Flux.just(1, 2, 3, 4, 5));

    }
}
