package haxul.sec03;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private final String name;

    public DefaultSubscriber(final String name) {
        this.name = name;
    }

    public DefaultSubscriber() {
        this.name = "";
    }

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + " got " + o + " " + Thread.currentThread().getName());
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(name + " error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " finished");
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(final String name) {
        return new DefaultSubscriber(name);
    }
}
