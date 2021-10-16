package haxul.sec01;

import reactor.core.publisher.Mono;

import java.io.*;
import java.util.concurrent.CompletableFuture;

public class FileService {
    private final String url = "/home/haxul/Development/workspaces/java/algorithm_tasks_solving/java/src/com/company/reactor/src/main/resources";

    public static void main(String[] args) {
        var fs = new FileService();

        Mono<String> mono = fs.read("hello.txt11");
        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("done")
        );
        System.out.println("end");
    }


    public Mono<Void> write(String content, String filename) {
        return Mono.fromRunnable(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(url + "/" + filename))) {
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Mono<String> read(String filename) {
        return Mono.fromFuture(
                CompletableFuture.supplyAsync(() -> {
                    try (BufferedReader reader = new BufferedReader(new FileReader(url + "/" + filename))) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            var curLine = reader.readLine();
                            if (curLine == null) break;
                            sb.append(curLine);
                        }
                        return sb.toString();
                    } catch (Exception e) {
                        throw  new RuntimeException(e.getMessage(), e);
                    }
                })
        );
    }
}
