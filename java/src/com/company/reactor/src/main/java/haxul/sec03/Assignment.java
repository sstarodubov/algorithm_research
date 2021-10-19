package haxul.sec03;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Consumer;

public class Assignment {

    public static void main(String[] args) {

        ReaderService.read()
                .take(5)
                .subscribeWith(DefaultSubscriber.subscriber());
    }
}


class ReaderService {

    @SneakyThrows
    public static Flux<String> read() {
        var path = "/home/haxul/Development/workspaces/java/algorithm_tasks_solving/java/src/com/company/reactor/src/main/java/haxul/sec03/text.txt";
        return Flux.create(new Consumer<>() {
            @Override
            @SneakyThrows
            public void accept(FluxSink<String> sink) {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    var curLine = "";
                    while (curLine != null) {
                        sink.next(curLine);
                        curLine = br.readLine();
                    }
                    sink.complete();
                }
            }
        });
    }
}
