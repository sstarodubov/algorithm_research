package haxul.sec02;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxI {
    public static void main(String[] args) {

//        var flux = Flux.just(1, 2, 3, 4, 5, 6);
//
//        flux.filter(i -> (i & 1) == 1).subscribe(i -> System.out.println("sub1: " + i));
//        flux.subscribe(i -> System.out.println("sub2: " + i));

        // flux from array list
//        Flux<Integer> flux = Flux.fromIterable(List.of(1, 3, 4, 5, 6));
//        flux.subscribe(System.out::println);

        // flux from stream
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//
//        Flux<Integer> flux = Flux.fromStream(list::stream);
//        flux.subscribe(System.out::println);
//        flux.subscribe(System.out::println);

        // flux range
//        Flux.range(1, 100).subscribe(System.out::println);

        Flux.range(1, 3)
                .log()
                .map( i -> Faker.instance().name().name())
                .log()
                .subscribe(System.out::println);
    }
}
