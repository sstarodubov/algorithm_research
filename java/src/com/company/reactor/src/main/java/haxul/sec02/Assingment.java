package haxul.sec02;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Assingment {
    public static void main(String[] args) {
        var s = new Stock();

        s.getStorage().subscribeWith(new StockSubscriber(1));
        s.getStorage().subscribeWith(new StockSubscriber(2));
    }
}

class StockSubscriber implements Subscriber<AtomicInteger> {

    private final int id;
    private final AtomicReference<Subscription> s;

    public StockSubscriber(final int id) {
        this.id = id;
        s = new AtomicReference<>();
    }


    @SneakyThrows
    private void fetch() {
        while (true) {
            Thread.sleep(1000);
            s.get().request(1);
        }
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println(this + " got subscription");
        s.set(subscription);
        new Thread(this::fetch).start();
    }

    @Override
    public void onNext(AtomicInteger integer) {
        System.out.println(this + " got price " + integer);
        if (integer.get() > 1000) {
            s.get().cancel();
            System.out.println(this + " cancel");
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(this + " got error" + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(this + " completed all");
    }

    @Override
    public String toString() {
        return "Subscriber " + id;
    }
}

class Stock {

    @Getter
    private final Flux<AtomicInteger> storage;

    private final AtomicInteger price = new AtomicInteger(0);
    private final Random random = new Random();
    private final BlockingQueue<Integer> candles = new ArrayBlockingQueue<>(100);

    public Stock() {
        storage = Flux.range(0, 100000)
                .map(el -> {
                    System.out.println("candle " + candles.element());
                    price.addAndGet(candles.element());
                    System.out.println("stock actual price " + price.get());
                    return price;
                });

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                candles.add(random.nextInt(100));
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (candles.size() > 90) {
                    candles.poll();
                }
            }
        }).start();
    }
}
