package haxul.sec01;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class FromFuture {

    public static void main(String[] args) throws InterruptedException {
//        Mono<String> mono = Mono.fromFuture(getName());
//
//        mono.subscribe(result -> System.out.println(result));
//
//        Thread.sleep(4000);

//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//
//
//            }
//            System.out.println("runnable");
//        };
//        Mono.fromRunnable(runnable)
//                .subscribe((a) -> System.out.println("1"),
//                        (e) -> System.out.println(e.getMessage()),
//                        () -> System.out.println("finish"));
//
//        Thread.sleep(2000);
    }


    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Faker.instance().name().name();
        });
    }
}
