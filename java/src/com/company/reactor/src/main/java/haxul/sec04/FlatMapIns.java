package haxul.sec04;

import com.github.javafaker.Faker;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FlatMapIns {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println("es");
            throw new RuntimeException("hoho");
        });

        System.out.println("here");
        Thread.sleep(2000);

//        UserService.getUsers()
//                .flatMap(user -> OrderService.getOrders(user.getUserId()))
//                .subscribe(e -> System.out.println(e));
    }
}


class UserService {
    public static Flux<User> getUsers() {
        return Flux.range(1, 2)
                .map(User::new);
    }
}

class OrderService {
    private final static Map<Integer, List<Order>> db = new HashMap<>();

    static {
        db.put(1, new ArrayList<>(List.of(
                new Order(1),
                new Order(1),
                new Order(1)
        )));

        db.put(2, new ArrayList<>(List.of(
                new Order(2),
                new Order(2)
        )));
    }

    public static Flux<Order> getOrders(int userId) {
        return Flux.create(sink -> {
            db.get(userId).forEach(sink::next);
            sink.complete();
        });
    }
}


@Data
class Order {
    private String item;
    private String price;
    private int userId;

    public Order(int userId) {
        this.userId = userId;
        this.item = Faker.instance().commerce().productName();
        this.price = Faker.instance().commerce().price();
    }
}

@Data
class User {
    private int userId;
    private String name;

    public User(int userId) {
        this.name = Faker.instance().name().name();
        this.userId = userId;
    }
}
