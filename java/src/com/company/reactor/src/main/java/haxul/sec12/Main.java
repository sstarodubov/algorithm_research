package haxul.sec12;

import haxul.sec03.DefaultSubscriber;
import reactor.core.publisher.Mono;

public class Main {
    public static void main(String[] args) {
        Mono.deferContextual(ctx -> {
                    if (ctx.hasKey("user")) return Mono.just("hello, " + ctx.get("user"));
                    return Mono.error(new RuntimeException("auth error"));
                })
                .contextWrite(ctx -> ctx.put("user", ctx.get("User")))
                .subscribe(DefaultSubscriber.subscriber());
    }
}
