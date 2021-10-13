package haxul.sec01;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;

public class FakeDemo {

    public static void main(String[] args) {
        userRepository(3)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("error" + err.getMessage()),
                        () -> System.out.println("done")
                        );

        System.out.println("last one");
    }

    @SneakyThrows
    private static Mono<String> userRepository(final int userId) {
        if (userId == 3) return Mono.error(new RuntimeException(" not allowed"));

        Thread.sleep(1000);
        var storage = Map.of(
                1, Faker.instance().name().fullName()
        );

        return Optional.ofNullable(storage.get(userId))
                .map(Mono::just)
                .orElse(Mono.empty());
    }
}
