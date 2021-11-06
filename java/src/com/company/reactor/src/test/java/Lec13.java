import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

import java.time.Duration;

public class Lec13 {

    @Test
    public void expectNext() {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

    @Test
    public void verifyError() {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Object> err = Flux.error(new RuntimeException("err"));
        Flux<Object> concat = Flux.concat(flux, err);

        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyError(RuntimeException.class);

    }

    @Test
    public void rangeTest() {
        Flux<Integer> flux = Flux.range(1, 50);
        StepVerifier.create(flux)
                .expectNextCount(50)
                .verifyComplete();
    }

    @Test
    public void consumeTest() {
        Flux<Integer> flux = Flux.range(1, 50);
        StepVerifier.create(flux)
                .thenConsumeWhile(num -> num < 55)
                .verifyComplete();
    }

    @Test
    public void assertTest() {
        Mono<BookOrder> bom = Mono.fromSupplier(BookOrder::new)
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(bom)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));
    }

    @Test
    public void virtualTimeTest() {
        StepVerifier.withVirtualTime(() -> Flux.range(1, 4)
                        .delayElements(Duration.ofSeconds(5))
                        .map(i -> i + "a"))
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a", "2a", "3a", "4a")
                .verifyComplete();
    }

    @Test
    public void virtualTimeTest2() {
        StepVerifier.withVirtualTime(() -> Flux.range(1, 4)
                        .delayElements(Duration.ofSeconds(5))
                        .map(i -> i + "a"))
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(4))
                .thenAwait(Duration.ofSeconds(20))
                .expectNext("1a", "2a", "3a", "4a")
                .verifyComplete();
    }

    @Test
    public void scenarioNameTest() {
//        Flux<Integer> flux = Flux.just(1, 2, 3, 5);
//        StepVerifierOptions sname = StepVerifierOptions.create().scenarioName("1,2,3,5 test");
//        StepVerifier.create(flux, sname)
//                .expectNextCount(12)
//                .verifyComplete();
        Flux<Integer> flux = Flux.just(1, 2);
        StepVerifier.create(flux)
                .expectNext(1)
                .as("1 is expected")
                .expectNext(3)
                .as("2 is expected")
                .verifyComplete();

    }


    @Test
    public void contextTest() {
        StepVerifierOptions opt = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));
        StepVerifier.create(Mono.deferContextual(ctx -> {
                    if (ctx.hasKey("user")) return Mono.just("welcome " + ctx.get("user"));
                    return Mono.error(new RuntimeException("err"));
                }), opt)
                .expectNext("welcome sam")
                .verifyComplete();
    }
}

@Getter
class BookOrder {
    private String author = "default";
}