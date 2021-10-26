package haxul.sec05;

import haxul.sec03.DefaultSubscriber;
import lombok.Getter;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Consumer;

public class Assingment {
    @SneakyThrows
    public static void main(String[] args) {
        var is = new InventoryService();
        var rs = new RevenueService();

        OrderService.fluid().subscribe(is.consumer);
        OrderService.fluid().subscribe(rs.consumer);

        is.stream().subscribe(DefaultSubscriber.subscriber("tesla"));
        rs.stream().subscribe(DefaultSubscriber.subscriber("devid"));

        Thread.sleep(100000);
    }
}

class OrderService {
    public static Flux<Long> fluid() {
        return Flux
                .interval(Duration.ofSeconds(2))
                .publish()
                .refCount(1);
    }
}

class InventoryService extends DefaultSubscriber {
    @Getter
    private long store = 0;

    public Consumer<Long> consumer = (num) -> {
        store += (num * 1000);
    };

    public Flux<Long> stream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> store)
                .publish()
                .refCount(1);
    }
}

class RevenueService extends DefaultSubscriber {

    @Getter
    private long rev = 0;

    public Consumer<Long> consumer = num -> {
        rev += (num + 5);
    };

    public Flux<Long> stream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> rev)
                .publish()
                .refCount(1);
    }
}