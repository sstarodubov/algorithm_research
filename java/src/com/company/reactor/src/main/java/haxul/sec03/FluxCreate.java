package haxul.sec03;

import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//            var cur = "";
//            while (!cur.equals("Canada")) {
//                cur = Faker.instance().country().name();
//                fluxSink.next(cur);
//            }
//            fluxSink.complete();
//        }).subscribe(DefaultSubscriber.subscriber());
        var np = new NameProducer();

        Flux.create(np).subscribe(DefaultSubscriber.subscriber());

        Runnable runnable = np::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        np.produce();
    }
}
