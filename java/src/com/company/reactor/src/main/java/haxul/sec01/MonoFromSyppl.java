package haxul.sec01;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.w3c.dom.ls.LSOutput;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Callable;

public class MonoFromSyppl {

    @SneakyThrows
    public static void main(String[] args) {

        // use just only when you have data already
//        Mono<String> just = Mono.just(getName());

//        Mono<String> mono = Mono.fromSupplier(() -> getName());
//
//        mono.subscribe(System.out::println);
//
//        Callable<String> callable = () -> getName();
//        Mono<String> stringMono = Mono.fromCallable(callable);
//        stringMono.subscribe(System.out::println);

        String block = getAsyncName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(block);
        System.out.println("hello");
    }


    private static Mono<String> getAsyncName() {
        System.out.println("Enter getName");
        return Mono.fromSupplier(
                        () -> {
                            System.out.println("Generate name..");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return Faker.instance().funnyName().name();
                        })
                .map(String::toUpperCase);
    }

    private static String getName() {
        System.out.println("Generate name..");
        return Faker.instance().funnyName().name();
    }
}
