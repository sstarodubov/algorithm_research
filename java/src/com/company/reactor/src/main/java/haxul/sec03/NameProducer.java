package haxul.sec03;

import com.github.javafaker.Faker;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }


    public void produce() {
        var name = Thread.currentThread().getName();
        fluxSink.next(name + " --- " + Faker.instance().name().name());
    }
}
