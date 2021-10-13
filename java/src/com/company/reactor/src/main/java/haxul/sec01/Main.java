package haxul.sec01;

import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> System.out.println("recieved: " + i));
    }
}
