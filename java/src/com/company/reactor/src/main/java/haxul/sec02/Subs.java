package haxul.sec02;

import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Subs {
    @SneakyThrows
    public static void main(String[] args) {
        var flx = Flux.range(1, 20);
        AtomicReference<Subscription> aS = new AtomicReference<>();
        flx.subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Got subscription: " + subscription);
                aS.set(subscription);
            }

            @SneakyThrows
            @Override
            public void onNext(Integer integer) {
                System.out.println("got: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });

        Thread.sleep(3000);
        aS.get().request(3);
        Thread.sleep(5000);
        aS.get().request(5);
        aS.get().cancel();
        Thread.sleep(1000);
        aS.get().request(1);
    }
}
