package haxul.sec02;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {

        Flux<String> names = NameGenerator.getNamesFlx(5);
        names.subscribe(System.out::println);
    }
}


class NameGenerator {

    public static Flux<String> getNamesFlx(int count) {
        return Flux.range(0, count).map(i -> getName());
    }

    public static List<String> getNames(int count) {
        var list = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    @SneakyThrows
    private static String getName() {
        Thread.sleep(1000);
        return Faker.instance().funnyName().name();
    }
}
