package haxul.sec03;

import reactor.core.publisher.Flux;

public class Take {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .take(4)
                .subscribeWith(DefaultSubscriber.subscriber());
    }
}
